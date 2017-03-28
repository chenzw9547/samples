package cn.chenzw.simple_axis2.ws;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.chenzw.simple_axis2.bean.Weather;
import cn.chenzw.simple_axis2.bean.WeekWeather;

/**
 * POJO方式
 * @author chenzw
 * @date 2017年3月28日
 */
public class WeatherWs {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(WeatherWs.class);

	/**
	 * 获取当天天气
	 * 
	 * @param weather
	 * @return
	 */
	public Weather getTodayWeather(Weather weather) {
		LOGGER.info("received:{}", weather);
		
		return weather;
	}

	/**
	 * 获取当周天气 -- 测试List参数与返回值
	 * 
	 * @return
	 */
	public List<Weather> getWeekWeather(Weather[] weathers) {
		LOGGER.info("received:{}", Arrays.toString(weathers));

		List<Weather> retWeatherList = new ArrayList<Weather>();
		retWeatherList.add(new Weather(25.2f, "It will rain", true, 3.5f));
		retWeatherList.add(new Weather(22.1f, "It is sun day", false, 0f));
		retWeatherList.add(new Weather(21.8f, "It is windy", false, 1.2f));
		retWeatherList.add(new Weather(19.2f, "It is cold", false, 0f));
		return retWeatherList;
	}

	/**
	 * 获取当周天气 -- 测试复杂对象的传送
	 * 
	 * @param weekWeather
	 * @return
	 */
	public WeekWeather getWeekWeather2(WeekWeather weekWeather) {
		LOGGER.info("received:{}", weekWeather);

		List<Weather> weatherList = new ArrayList<Weather>();
		weatherList.add(new Weather(25.2f, "It will rain", true, 3.5f));
		weatherList.add(new Weather(22.1f, "It is sun day", false, 0f));
		weatherList.add(new Weather(21.8f, "It is windy", false, 1.2f));
		weatherList.add(new Weather(19.2f, "It is cold", false, 0f));

		WeekWeather retWeekWeather = new WeekWeather();
		retWeekWeather.setDate(new Date());
		// 将列表转换成数组
		retWeekWeather.setWeathers(weatherList.toArray(new Weather[1]));

		return retWeekWeather;
	}

}
