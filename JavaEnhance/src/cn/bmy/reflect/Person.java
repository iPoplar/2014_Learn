package cn.bmy.reflect;

public class Person {
	
	public String name;  //字段或成员变量
	private int age;
	public final String password = "123";  //字段或成员变量
	
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	

	public Person()
	{
		System.out.println("无参构造函数——person!!!!!");
	}
	
	public Person(String name)
	{
		System.out.println("这是参数为String name的方法中的："+name);
	}
	
	
	private Person(int name)
	{
		System.out.println("这是参数为int name的方法中的："+name);
	}
	
	public void eat()
	{
		System.out.println("eat!!!!");
	}
	
	public void run(String address)
	{
		System.out.println("跑到" + address);
	}
	
	public void run(String address,int num[],String ss[])
	{
		System.out.println("跑到" + address + "," + num);
	}
	
	public String test(String str)
	{
		return str + "aaaa";
	}
	
	private String test2(String str)
	{
		return str + "aaaa2";
	}
	
	public static String test3(String str)
	{
		return str + "aaaa3";
	}
	
	public static void main(String[] args) 
	{
		System.out.println(args[0]);
	}
}
