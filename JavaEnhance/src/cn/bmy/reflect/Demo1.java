package cn.bmy.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.junit.Test;

public class Demo1
{
	/**
	 * 反射就是把Java类中的各种成分映射成一个个的java对象。
	 * 例如，一个类有：成员变量，方法，构造方法，包等等信息，利用反射技术可以对一个类进行解剖，
	 * 把各个组成部分映射成一个个对象。
	 *========================================================= 
	 * Class文件：
	 * 如何得到某个class文件对应的class对象。
	 *	类名.class，
	 *	对象.getClass()
	 *	Class.forName(“类名”) 
	 *
	 *	数组类型的Class实例对象
	 *	Class.isArray()
	 *
	 *	总之，只要是在源程序中出现的类型，都有各自的Class实例对象，例如，int，void…
	 *=========================================================
	 * Constructor类
	 * Constructor类的实例对象代表类的一个构造方法。

	 *	得到某个类所有的构造方法，例：
	 *	Constructor [] constructors= Class.forName("java.lang.String").getConstructors();
	 *
	 *	得到某一个构造方法，例： 	    
	 *	Constructor constructor = Class.forName(“java.lang.String”).getConstructor(StringBuffer.class);
	 *	
	 *	利用构造方法创建实例对象：
	 *	String str = (String)constructor.newInstance(“abc”);
	 *	
	 *	Class类的newInstance()方法也可创建类的实例，其内部工作原理是先得无参的构造方法，再用构造方法创建实例对象。
	 *	String obj =(String)Class.forName("java.lang.String").newInstance();
	 *=========================================================
	 *Field类的用法，看ReflectPoint类和test类
	 *=========================================================
	 *Method类代表某个类中的一个成员方法
	 *	得到类中的某一个方法：
	 *	例子： 	    Method charAt = Class.forName("java.lang.String").getMethod("charAt", int.class);
	 *	调用方法：
	 *	通常方式：System.out.println(str.charAt(1));
	 *	反射方式： System.out.println(charAt.invoke(str, 1)); 
	 *	如果传递给Method对象的invoke()方法的第一个参数为null，这有着什么样的意义呢？说明该Method对象对应的是一个静态方法！
	 *=========================================================
	 *访问JavaBean属性的两种方式：
	 *	直接调用bean的setXXX或getXXX方法。
	 *	通过内省技术访问(java.beans包提供了内省的API)，内省技术访问也提供了两种方式。
	 *	通过PropertyDescriptor类操作Bean的属性
	 *	通过Introspector类获得Bean对象的 BeanInfo，然后通过 BeanInfo 来获取属性的描述器（ PropertyDescriptor ），
	 *	通过这个属性描述器就可以获取某个属性对应的 getter/setter 方法，然后通过反射机制来调用这些方法。
	 */

	//反射类无参的构造方法
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
	
	//反射类有参的构造方法：public Person(String name)
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

	
	//反射类私有的、有参的构造方法：private Person(int name)
	@Test
	public void test3() throws ClassNotFoundException,
			NoSuchMethodException, InstantiationException,
			IllegalAccessException, InvocationTargetException
	{
		Class clazz = Class.forName("cn.bmy.reflect.Person");
		
		Constructor c = clazz.getDeclaredConstructor(int.class);
		//暴力反射      		
		//三步曲   	一是不让你知道我有钱      二是把钱晃一下，不给用     三是暴力抢了
		//这个管你是公的私的，都拿来
		c.setAccessible(true);//暴力反射
		Person p = (Person) c.newInstance(1);
		System.out.println(p);
	}
}
