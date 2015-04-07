package cn.bmy.reflect;

import java.lang.reflect.Method;

import org.junit.Test;

public class Demo2 
{
	/**
	 * ���䷽��
	 * *Method�����ĳ�����е�һ����Ա����
	 *	�õ����е�ĳһ��������
	 *	���ӣ� 	    Method charAt = Class.forName("java.lang.String").getMethod("charAt", int.class);
	 *	���÷�����
	 *	ͨ����ʽ��System.out.println(str.charAt(1));
	 *	���䷽ʽ�� System.out.println(charAt.invoke(str, 1)); 
	 *	������ݸ�Method�����invoke()�����ĵ�һ������Ϊnull��������ʲô���������أ�˵����Method�����Ӧ����һ����̬������
	 */

	//���䣺public void eat()
	@Test
	public void test1() throws Exception
	{
		Person p = new Person();  
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");  //��������
		Method method = clazz.getMethod("eat", null);  //eat
		method.invoke(p, null);  //eat
	}
	
	//���䣺run(String address)
	@Test
	public void test2() throws Exception
	{
		Person p = new Person();  
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");  
		Method method = clazz.getMethod("run", String.class);
		method.invoke(p, "����");
		
	}
	
	//���䣺public void run(String address,int num[],String ss[]){
	@Test
	public void test3() throws Exception
	{
		Person p = new Person();  //
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");  //��������
		Method method = clazz.getMethod("run", String.class,int[].class,String[].class);
		method.invoke(p, "�Ϻ�",new int[]{1,2},new String[]{"1","2"});
	}
	
	
	//���䣺public String test(String str) (������ֵ)
	@Test
	public void test4() throws Exception
	{
		Person p = new Person();  //
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");  //��������
		Method method = clazz.getMethod("test", String.class);
		String result = (String) method.invoke(p, "xxxx");
		System.out.println(result);
	}
	
	//���䣺private String test2(String str)  ˽�з���
	@Test
	public void test5() throws Exception{
		
		Person p = new Person();  //
		Class clazz = Class.forName("cn.bmy.reflect.Person");  //��������
		Method method = clazz.getDeclaredMethod("test2", String.class);
		method.setAccessible(true);
		method.invoke(p, "");
	}
	
	//���䣺public static String test3(String str){ ��̬����
	@Test
	public void test6() throws Exception{
		
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");  //��������
		
		Method method = clazz.getMethod("test3", String.class);
		String result = (String) method.invoke(null, "aaa");
		System.out.println(result);
		
	}
	
	//���䣺public static void main(String[] args) {  ����main����  
	//ͨ��������ô�����ķ�����Ҫע�⴦��
	@Test
	public void test7() throws Exception{
		
		
		Class clazz = Class.forName("cn.bmy.reflect.Person");  //��������
		
		Method method = clazz.getMethod("main", String[].class);
		method.invoke(null, (Object)new String[]{"1","2"});//main(String args[])
		//method.invoke(null, new Object[]{new String[]{"1","2"}});//main(String args[])
		
		
		//public Object invoke(Object obj, Object... args)  //jdk1.5
		//public Object invoke(Object obj, Object[] args)  //jdk1.4
		
		//public void run(String name,String password)  
		//method.invoke(p,new Object[]{"flx,123"})//1.4
		//method.invoke(p,"flx","123")

		
	}
	
	
	
}
