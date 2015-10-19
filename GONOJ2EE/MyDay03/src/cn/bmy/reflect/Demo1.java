package cn.bmy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo1
{
	/**
	 * 利用Constructor创建对象
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * 
	 */
	/*//反射类无参的构造方法
	@Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{///MyDay03/src/cn/bmy/reflect/Person.java
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		Constructor c = clazz.getConstructor(null);
		Object obj = c.newInstance(null);
		
		System.out.println(obj);
	}
	*/
	
	@Test
	public void test1() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		
		Constructor c = clazz.getConstructor(null);
		
		Object obj = c.newInstance(null);
		
		System.out.println(obj);
	}
	//反射类有参的构造方法
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		Constructor c = clazz.getConstructor(String.class);
		Person p = (Person) c.newInstance("bmy");
		System.out.println(p);
	}
}
