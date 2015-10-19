package cn.bmy.teareflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

//cn.bmy.teareflect.Person
public class Demo3
{
	//反射方法
	//反射；public void eat()
	@Test
	public void test1() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("eat", null);
		
		method.invoke(p, null);
	}
	
	//反射：run(String address)
	@Test
	public void test2() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method me = clazz.getMethod("run", String.class);
		me.invoke(p, "北极");
	}
	//反射；public void run(String address ,int num[] , String ss[])
	@Test
	public void test3() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		
		Method method = clazz.getMethod("run", String.class,int[].class, String[].class);
		method.invoke(p, "上海", new int[] {1,2},new String[] {"1","2"});
			
	}
	
	//反射：public String test(String str)(带返回值)
	@Test
	public void test4() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("test", String.class);
		String result = (String) method.invoke(p, "xixix");
		System.out.println(result);
		
	}
	
	//反射：private String test2(String str)  私有方法
	@Test
	public void test5() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Person p = new Person();
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method  = clazz.getMethod("test2", String.class);
		method.setAccessible(true);
		method.invoke(p, "");
		
	}
	
	//反射：public static String test3(String str) /静态方法
	@Test
	public void test6() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("test3", String.class);
		String result = (String) method.invoke(null, "aaa");
		System.out.println(result);
	}
	//反射：public static void main(String[] arsgs) 反射main方法
	@Test
	public void test7() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.teareflect.Person");
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, (Object)new String[]{"1","2"});
	}

}
