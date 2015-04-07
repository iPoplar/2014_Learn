package cn.bmy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo1
{
	/**
	 * ������ǰ�Java���еĸ��ֳɷ�ӳ���һ������java����
	 * ���磬һ�����У���Ա���������������췽�������ȵ���Ϣ�����÷��似�����Զ�һ������н��ʣ�
	 * �Ѹ�����ɲ���ӳ���һ��������
	 *========================================================= 
	 * Class�ļ���
	 * ��εõ�ĳ��class�ļ���Ӧ��class����
	 *	����.class��
	 *	����.getClass()
	 *	Class.forName(��������) 
	 *
	 *	�������͵�Classʵ������
	 *	Class.isArray()
	 *
	 *	��֮��ֻҪ����Դ�����г��ֵ����ͣ����и��Ե�Classʵ���������磬int��void��
	 *=========================================================
	 * Constructor��
	 * Constructor���ʵ������������һ�����췽����

	 *	�õ�ĳ�������еĹ��췽��������
	 *	Constructor [] constructors= Class.forName("java.lang.String").getConstructors();
	 *
	 *	�õ�ĳһ�����췽�������� 	    
	 *	Constructor constructor = Class.forName(��java.lang.String��).getConstructor(StringBuffer.class);
	 *	
	 *	���ù��췽������ʵ������
	 *	String str = (String)constructor.newInstance(��abc��);
	 *	
	 *	Class���newInstance()����Ҳ�ɴ������ʵ�������ڲ�����ԭ�����ȵ��޲εĹ��췽�������ù��췽������ʵ������
	 *	String obj =(String)Class.forName("java.lang.String").newInstance();
	 *=========================================================
	 *Field����÷�����ReflectPoint���test��
	 *=========================================================
	 *Method�����ĳ�����е�һ����Ա����
	 *	�õ����е�ĳһ��������
	 *	���ӣ� 	    Method charAt = Class.forName("java.lang.String").getMethod("charAt", int.class);
	 *	���÷�����
	 *	ͨ����ʽ��System.out.println(str.charAt(1));
	 *	���䷽ʽ�� System.out.println(charAt.invoke(str, 1)); 
	 *	������ݸ�Method�����invoke()�����ĵ�һ������Ϊnull��������ʲô���������أ�˵����Method�����Ӧ����һ����̬������
	 *=========================================================
	 *����JavaBean���Ե����ַ�ʽ��
	 *	ֱ�ӵ���bean��setXXX��getXXX������
	 *	ͨ����ʡ��������(java.beans���ṩ����ʡ��API)����ʡ��������Ҳ�ṩ�����ַ�ʽ��
	 *	ͨ��PropertyDescriptor�����Bean������
	 *	ͨ��Introspector����Bean����� BeanInfo��Ȼ��ͨ�� BeanInfo ����ȡ���Ե��������� PropertyDescriptor ����
	 *	ͨ����������������Ϳ��Ի�ȡĳ�����Զ�Ӧ�� getter/setter ������Ȼ��ͨ�����������������Щ������
	 */

	//�������޲εĹ��췽��
	@Test
	public void test1() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException 
	{		
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		
		Constructor c = clazz.getConstructor(null);  
		
		Object obj = c.newInstance(null);
		
		System.out.println(obj);
	}
	
	//�������вεĹ��췽����public Person(String name)
	@Test
	public void test2() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException 
	{
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		
		Constructor c = clazz.getConstructor(String.class);
		
		Person p = (Person) c.newInstance("flx");
		
		System.out.println(p);
	}

	
	//������˽�еġ��вεĹ��췽����private Person(int name)
	@Test
	public void test3() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		
		Constructor c = clazz.getDeclaredConstructor(int.class);
		//��������      		
		//������   	һ�ǲ�����֪������Ǯ      ���ǰ�Ǯ��һ�£�������     ���Ǳ�������
		//��������ǹ���˽�ģ�������
		c.setAccessible(true);//��������
		Person p = (Person) c.newInstance(1);
		System.out.println(p);
	}
}
