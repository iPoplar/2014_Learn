package cn.bmy.base;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Reflect 
{
	@Test
	public  void test1() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException
			{
				Class clazz = Class.forName("cn.bmy.base.Person");
				Constructor c = clazz.getConstructor(String.class);
				Person p = (Person) c.newInstance("12345");
				System.out.println(c+"@@This is c");
				System.out.println(p+"@@This is p");
			}
	
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException,
			SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.base.Person");
		Constructor c = clazz.getDeclaredConstructor(int.class);
		c.setAccessible(true);
		Person p = (Person) c.newInstance(1);
		System.out.println(p);
		
	}
}

