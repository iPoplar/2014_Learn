package cn.bmy.reflect;

import java.lang.reflect.Field;

import org.junit.Test;

public class Demo3 
{
	/**��������ֶ�
	 * Field����÷�����ReflectPoint���test��
	 * @param args
	 * @throws Exception 
	 */	
	//���䣺public String name; 
	@Test
	public void test1() throws Exception
	{
		Person p = new Person();
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");		
		Field f = clazz.getField("name");  //name		
		f.set(p, "flx");		
		System.out.println(p.getName());		
	}
	
	//���䣺public String name; 
	@Test
	public void test2() throws Exception
	{
		Person p = new Person();
		p.setName("xxx");		
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		Field f = clazz.getField("name");  //name
		String result = (String) f.get(p);
		System.out.println(result);
	}
	
	//���䣺public final String password = "";  //�ֶλ��Ա����
	@Test
	public void test3() throws Exception
	{		
		Person p = new Person();
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		Field f = clazz.getField("password");  //name
		String result = (String)f.get(p);
		System.out.println(result);		
	}	
	
	//���䣺private int age; ˽���ֶ�
	@Test
	public void test4() throws Exception
	{
		Person p = new Person();
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		Field f = clazz.getDeclaredField("age");
		f.setAccessible(true);		
		f.set(p, 123);
		
		int result = (Integer) f.get(p);
		System.out.println(result);
	}
}
