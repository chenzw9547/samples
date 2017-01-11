package cn.chenzw.simple_axis2.ws;

import java.util.ArrayList;
import java.util.List;

import cn.chenzw.simple_axis2.bean.Weather;

public class WeatherWs {

	/**
	 * 获取当天天气
	 * 
	 * @param weather
	 * @return
	 */
	public Weather getTodayWeather(Weather weather) {
		System.out.println("接收:" + weather);
		return weather;
	}

	/**
	 * 获取当周天气
	 * 
	 * @return
	 */
	public List<Weather> getWeekWeather() {
		List<Weather> weatherList = new ArrayList<Weather>();
		weatherList.add(new Weather(25.2f, "It will rain", true, 3.5f));
		weatherList.add(new Weather(22.1f, "It is sun day", false, 0f));
		weatherList.add(new Weather(21.8f, "It is windy", false, 1.2f));
		weatherList.add(new Weather(19.2f, "It is cold", false, 0f));
		return weatherList;
	}

}
