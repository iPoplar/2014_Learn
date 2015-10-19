package cn.bmy.teareflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class Demo4 
{
	/**
	 * ��������ֶ�
	 * @throws ClassNotFoundException 
	 * @throws SecurityException 
	 * @throws NoSuchFieldException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	//���䣺public String name;
	public void test1() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Field f = clazz.getField("name");
		f.set(p, "bmy");
		System.out.println(p.getName());
		
	}
	
	//���䣺public String name;
	public void test2() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Person p = new Person();
		p.setName("hehee");
		
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Field f = clazz.getField("name");
		String result = (String) f.get(p);
		System.out.println(result);
			
	}
	
	//���䣺 public final String password = ""   �ֶλ��Ա����
	public void test3() throws ClassNotFoundException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);
		
		f.set(p, 123);
		
		int result = (Integer) f.get(p);
		System.out.println(result);
	}

	
}
