package cn.chenzw.simple_axis2.bean;

public class Weather {
	private float temperature;
	private String forecast;
	private boolean rain;
	private float howMuchRain;
	
	public Weather(){}

	public Weather(float temperature, String forecast, boolean rain,
			float howMuchRain) {
		super();
		this.temperature = temperature;
		this.forecast = forecast;
		this.rain = rain;
		this.howMuchRain = howMuchRain;
	}

	public void setTemperature(float temp) {
		temperature = temp;
	}

	public float getTemperature() {
		return temperature;
	}

	public void setForecast(String fore) {
		forecast = fore;
	}

	public String getForecast() {
		return forecast;
	}

	public void setRain(boolean r) {
		rain = r;
	}

	public boolean getRain() {
		return rain;
	}

	public void setHowMuchRain(float howMuch) {
		howMuchRain = howMuch;
	}

	public float getHowMuchRain() {
		return howMuchRain;
	}

	@Override
	public String toString() {
		return "Weather [temperature=" + temperature + ", forecast=" + forecast
				+ ", rain=" + rain + ", howMuchRain=" + howMuchRain + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((forecast == null) ? 0 : forecast.hashCode());
		result = prime * result + Float.floatToIntBits(howMuchRain);
		result = prime * result + (rain ? 1231 : 1237);
		result = prime * result + Float.floatToIntBits(temperature);
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (forecast == null) {
			if (other.forecast != null)
				return false;
		} else if (!forecast.equals(other.forecast))
			return false;
		if (Float.floatToIntBits(howMuchRain) != Float
				.floatToIntBits(other.howMuchRain))
			return false;
		if (rain != other.rain)
			return false;
		if (Float.floatToIntBits(temperature) != Float
				.floatToIntBits(other.temperature))
			return false;
		return true;
	}
	
	
	
}