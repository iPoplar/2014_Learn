package cn.bmy.reflect;

public class Person {
	
	public String name;  //�ֶλ��Ա����
	private int age;
	public final String password = "123";  //�ֶλ��Ա����
	
		
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
		System.out.println("�޲ι��캯������person!!!!!");
	}
	
	public Person(String name)
	{
		System.out.println("���ǲ���ΪString name�ķ����еģ�"+name);
	}
	
	
	private Person(int name)
	{
		System.out.println("���ǲ���Ϊint name�ķ����еģ�"+name);
	}
	
	public void eat()
	{
		System.out.println("eat!!!!");
	}
	
	public void run(String address)
	{
		System.out.println("�ܵ�" + address);
	}
	
	public void run(String address,int num[],String ss[])
	{
		System.out.println("�ܵ�" + address + "," + num);
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
