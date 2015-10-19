package cn.bmy.teareflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

//cn.bmy.teareflect.Person
public class Demo3
{
	//���䷽��
	//���䣻public void eat()
	@Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("eat", null);
		
		method.invoke(p, null);
	}
	
	//���䣺run(String address)
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method me = clazz.getMethod("run", String.class);
		me.invoke(p, "����");
	}
	//���䣻public void run(String address ,int num[] , String ss[])
	@Test
	public void test3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Method method = clazz.getMethod("run", String.class,int[].class, String[].class);
		method.invoke(p, "�Ϻ�", new int[] {1,2},new String[] {"1","2"});
			
	}
	
	//���䣺public String test(String str)(������ֵ)
	@Test
	public void test4() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("test", String.class);
		String result = (String) method.invoke(p, "xixix");
		System.out.println(result);
		
	}
	
	//���䣺private String test2(String str)  ˽�з���
	@Test
	public void test5() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method  = clazz.getMethod("test2", String.class);
		method.setAccessible(true);
		method.invoke(p, "");
		
	}
	
	//���䣺public static String test3(String str) /��̬����
	@Test
	public void test6() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("test3", String.class);
		String result = (String) method.invoke(null, "aaa");
		System.out.println(result);
	}
	//���䣺public static void main(String[] arsgs) ����main����
	@Test
	public void test7() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, (Object)new String[]{"1","2"});
	}

}
