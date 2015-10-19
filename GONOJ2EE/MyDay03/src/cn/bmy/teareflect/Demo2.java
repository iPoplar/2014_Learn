package cn.bmy.teareflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo2 {

	/**
	 * 利用Constructor创建对象
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Exception 
	 */

	//反射类无参的构造方法
	@Test
	public void test1() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Constructor c = clazz.getConstructor(null);
		
		Object obj = c.newInstance(null);
		
		System.out.println(obj);
	}
		
	//反射类有参的构造方法：public Person(String name)
	@Test
	public void test2() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Constructor c = clazz.getConstructor(String.class);
		
		Person p = (Person) c.newInstance("flx");
		
		System.out.println(p);
	}

	
	//反射类私有的、有参的构造方法：private Person(int name)
	@Test
	public void test3() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Constructor c = clazz.getDeclaredConstructor(int.class);
		c.setAccessible(true);//暴力反射
		Person p = (Person) c.newInstance(1);
		System.out.println(p);
	}
}
