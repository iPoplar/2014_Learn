package junit.test;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import cn.bmy.Day3Person;

public class DayPersonTest2 
{

	@Before
	public void setUp() throws Exception 
	{
		System.out.println("This is test Befor!");
	}

	@After
	public void tearDown() throws Exception
	{
		System.out.println("This is test After!");
	}
	
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
