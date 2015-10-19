package cn.bmy.test;

import cn.bmy.weather.CurrentConditionsDisplay;
import cn.bmy.weather.WeatherDataDemo1;

public class WeatherStation 
{
	public static void main(String[] args) 
	{
		WeatherDataDemo1 weatherData = new WeatherDataDemo1();
		CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(weatherData);
		//StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
		//ForecastDisplay forecastDisplay = new ForcastDispaly(weatherData);
		
		weatherData.setMeasurements(80, 65, 30.2f);
		weatherData.setMeasurements(82, 70, 22.4f);
		weatherData.setMeasurements(70, 45, 12.2f);
		
		
	}

}
