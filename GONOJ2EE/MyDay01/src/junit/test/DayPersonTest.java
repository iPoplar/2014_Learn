package junit.test;

import org.junit.Test;

import cn.bmy.Day3Person;

public class DayPersonTest 
{
	@Test
	public void testXixi()
	{
		Day3Person x = new Day3Person();
		x.xixi();		
	}
	
	@Test
	public void testGo()
	{
		Day3Person y = new Day3Person();
		y.go();
	}
	
	
}
