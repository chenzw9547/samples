package cn.chenzw.simple_axis2.bean;

import java.util.Arrays;
import java.util.Date;

public class WeekWeather {

	private Date date;
	/**
	 * pojo方式不支持复杂的数据结构(如List),集合类只能使用数组
	 */
	private Weather[] weathers;
	

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Weather[] getWeathers() {
		return weathers;
	}

	public void setWeathers(Weather[] weathers) {
		this.weathers = weathers;
	}


	@Override
	public String toString() {
		return "WeekWeather [date=" + date + ", weathers="
				+ Arrays.toString(weathers) + "]";
	}
	
}
