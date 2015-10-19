package cn.bmy.teareflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo2 {

	/**
	 * ����Constructor��������
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws Exception 
	 */

	//�������޲εĹ��췽��
	@Test
	public void test1() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Constructor c = clazz.getConstructor(null);
		
		Object obj = c.newInstance(null);
		
		System.out.println(obj);
	}
		
	//�������вεĹ��췽����public Person(String name)
	@Test
	public void test2() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Constructor c = clazz.getConstructor(String.class);
		
		Person p = (Person) c.newInstance("flx");
		
		System.out.println(p);
	}

	
	//������˽�еġ��вεĹ��췽����private Person(int name)
	@Test
	public void test3() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException {
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Constructor c = clazz.getDeclaredConstructor(int.class);
		c.setAccessible(true);//��������
		Person p = (Person) c.newInstance(1);
		System.out.println(p);
	}
}
