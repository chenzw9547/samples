package cn.chenzw.simple_axis2.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import cn.chenzw.simple_axis2.bean.Weather;
import cn.chenzw.simple_axis2.bean.WeekWeather;

/**
 * 使用POJO方式
 * 
 * @see http://axis.apache.org/axis2/java/core/docs/pojoguide.html
 * @author chenzw
 * @date 2017年1月11日
 */
public class TestWeatherWs {

	private static final String WEATHER_WS_URL = "http://localhost:8888/simple-axis2/services/WeatherService";
	private static final String WEATHER_SPRING_WS_URL = "http://localhost:8888/simple-axis2/services/WeatherSpringService";

	public static void main(String[] args) throws AxisFault {
		TestWeatherWs weatherWs = new TestWeatherWs();
		// weatherWs.testArgsAndReturnObj();
		// weatherWs.testArgsAndReturnList();
		// weatherWs.testComplexObje();
		weatherWs.testPojoSpring();
	}

	/**
	 * 测试参数和返回对象
	 * 
	 * @throws AxisFault
	 */
	public void testArgsAndReturnObj() throws AxisFault {
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(WEATHER_WS_URL);
		options.setTo(targetEPR);

		// 构建调用方法的参数
		Weather weather = new Weather();
		weather.setTemperature(39.3f);
		weather.setForecast("Cloudy with showers");
		weather.setRain(true);
		weather.setHowMuchRain(4.5f);

		Object[] retObjs = serviceClient.invokeBlocking(new QName(
				"http://ws.simple_axis2.chenzw.cn", "getTodayWeather"),
				new Object[] { weather }, new Class[] { Weather.class });
		for (Object retObj : retObjs) {
			if (retObj instanceof Weather) {
				Weather todayWeather = (Weather) retObj;
				// Assert.assertEquals(weather, todayWeather);
			}
		}
	}

	/**
	 * 测试返回List对象
	 * 
	 * @throws AxisFault
	 */
	public void testArgsAndReturnList() throws AxisFault {
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(WEATHER_WS_URL);
		options.setTo(targetEPR);

		// 构建
		List<Weather> weatherList = new ArrayList<Weather>();
		for (int i = 0; i < 7; i++) {
			Weather weather = new Weather();
			weather.setRain(false);
			weather.setForecast("晴天");
			weather.setTemperature(i);
			weatherList.add(weather);
		}

		// 返回List对象，必须使用Weather[].class作为返回参数
		Object[] retObjs = serviceClient.invokeBlocking(new QName(
				"http://ws.simple_axis2.chenzw.cn", "getWeekWeather"),
				new Object[] { weatherList.toArray() },
				new Class[] { Weather[].class });

		for (Object retObj : retObjs) {
			Weather[] weathers = (Weather[]) retObj;
			System.out.println(Arrays.toString(weathers));
		}

	}

	/**
	 * 测试复杂对象
	 * 
	 * @throws AxisFault
	 */
	public void testComplexObje() throws AxisFault {
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(WEATHER_WS_URL);
		options.setTo(targetEPR);

		// 构建
		List<Weather> weatherList = new ArrayList<Weather>();
		for (int i = 0; i < 7; i++) {
			Weather weather = new Weather();
			weather.setRain(false);
			weather.setForecast("晴天");
			weatherList.add(weather);
		}

		WeekWeather weekWeather = new WeekWeather();
		weekWeather.setDate(new Date());
		weekWeather.setWeathers(weatherList.toArray(new Weather[1]));

		Object[] retObjs = serviceClient
				.invokeBlocking(new QName("http://ws.simple_axis2.chenzw.cn",
						"getWeekWeather2"), new Object[] { weekWeather },
						new Class[] { WeekWeather.class });

		for (Object retObj : retObjs) {
			if (retObj instanceof WeekWeather) {
				WeekWeather ww = (WeekWeather) retObj; // 复杂对象，里面带着对象数组
				System.out.println(ww);
			}
		}
	}

	public void testPojoSpring() throws AxisFault {
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(
				WEATHER_SPRING_WS_URL);
		options.setTo(targetEPR);

		serviceClient.invokeBlocking(new QName(
				"http://ws.simple_axis2.chenzw.cn", "getTodayWeather"),
				new Object[] {}, new Class[] {});
	}
}
