package cm.dao;

//implements��һ����ʵ��һ���ӿ��õĹؼ���,��������ʵ�ֽӿ��ж���ĳ��󷽷�
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
