package cn.bmy.weather;

import java.util.ArrayList;

public class WeatherDataDemo1 implements Subject 
{
	private ArrayList observers;
	private float temperature;
	private float humidity;
	private float pressure;

	
	
	public WeatherDataDemo1()
	{
		observers = new ArrayList();
	}
	
	//��ע��۲���ʱ������ֻҪ�����ӵ�ArrayList�ĺ��漴��
	public void registerObserver(Observer o) 
	{
		observers.add(o);	
	}

	public void removeObserver(Observer o) 
	{
		int i = observers.indexOf(o);
		if(i >= 0)
		{
			observers.remove(i);
		}
		
	}

	public void notifyObservers() 
	{
		for(int i = 0; i < observers.size(); i++)
		{
			Observer observer = (Observer) observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
		
	}
	
	public void measurementsChange()
	{
		notifyObservers();
	}

	public void setMeasurements(float temperature, float humidity, float pressure)
	{
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		measurementsChange();
	}
	//WeatherData����������
}
