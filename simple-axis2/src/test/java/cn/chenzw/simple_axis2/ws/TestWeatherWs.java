package cn.chenzw.simple_axis2.ws;

import java.awt.List;
import java.util.ArrayList;

import javax.xml.namespace.QName;

import junit.framework.Assert;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import cn.chenzw.simple_axis2.bean.Weather;

public class TestWeatherWs {

	public static void main(String[] args) throws AxisFault {
		TestWeatherWs weatherWs = new TestWeatherWs();
		weatherWs.testArgsAndReturnObj();
		weatherWs.testReturnList();
	}

	/**
	 * 测试参数和返回对象
	 * 
	 * @throws AxisFault
	 */
	public void testArgsAndReturnObj() throws AxisFault {
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8989/simple-axis2/services/weatherService");
		options.setTo(targetEPR);

		//构建调用方法的参数
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
				Assert.assertEquals(weather, todayWeather);
			}
		}
	}

	/**
	 * 测试返回List对象
	 * 
	 * @throws AxisFault
	 */
	public void testReturnList() throws AxisFault {
		RPCServiceClient serviceClient = new RPCServiceClient();
		Options options = serviceClient.getOptions();

		EndpointReference targetEPR = new EndpointReference(
				"http://localhost:8989/simple-axis2/services/weatherService");
		options.setTo(targetEPR);

		// 返回List对象，必须使用Weather[].class作为返回参数
		Object[] retObjs = serviceClient.invokeBlocking(new QName(
				"http://ws.simple_axis2.chenzw.cn", "getWeekWeather"),
				new Object[] {}, new Class[] { Weather[].class });

		for (Object retObj : retObjs) {
			Weather[] weathers = (Weather[]) retObj;
			for (Weather w : weathers) {
				System.out.println(w);
			}
		}
	}

}
