package cn.bmy.enumeration4;

public class Test 
{
	public static void main(String[] args) 
	{
		
		Student s = new Student();
		s.setGrade(Grade.A);
		
		String value = Grade.C.getValue();
		System.out.println(value);
		
		value = Grade.D.toLocaleString();
		System.out.println(value);
		
	}
	public void test()
	{
		//枚举的常用方法:name valueOf values
		
		String name = "B";
		
		Grade g = Grade.valueOf(Grade.class,name);//把字符串转成枚举对象
		
		System.out.println(g.name());//获取枚举对象名称
		
		//得到一个枚举类的所有对象
		Grade gs[] = Grade.values();//A B C D E
		for(Grade g1 : gs)
		{
			System.out.println(g1.name());
		}
		
	}

}
