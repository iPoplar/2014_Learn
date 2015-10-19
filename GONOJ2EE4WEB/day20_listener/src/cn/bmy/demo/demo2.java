package cn.bmy.demo;



public class demo2 
{
	/**
	 * ���һ���¼�Դ�������������� 	Observer(�۲������ģʽ)
	 */

	public static void main(String[] args) 
	{
		Person p = new Person();
		
	}
}

class Person
{
	private PersonListener listener;
	
	public void eat()
	{
		if(listener != null)
		{
			listener.doeat(new Event(this));
		}
	}
	
	public void run()
	{
		if(listener != null)
		{
			listener.dorun(new Event(this));
		}
	}
	
	public void registerListener(PersonListener listener)
	{
		this.listener = listener;
	}
	
	
}

interface PersonListener
{
	public void doeat(Event e);
	public void dorun(Event e);
}

class Event
{
	private Person source;
	
	public Event()
	{
		super();
	}
	
	public Event(Person source)
	{
		super();
		this.source = source;
	}
	
	public Person getSource()
	{
		return source;
	}
	
	public void setSource(Person source)
	{
		this.source = source;
	}
}