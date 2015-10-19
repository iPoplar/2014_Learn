package cm.dao;

//implements是一个类实现一个接口用的关键字,它是用来实现接口中定义的抽象方法
public class Impl1 implements ITestDao 
{
	private String name;
	
	public void say() 
	{
		System.out.println("1111");
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
