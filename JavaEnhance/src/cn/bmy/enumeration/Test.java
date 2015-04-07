package cn.bmy.enumeration;

public class Test
{
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Student s = new Student();
		s.setGrade(Grade.A);  //Grade		
		
		String value = Grade.C.getValue();
		System.out.println(value+"->Grade.C.toLocaleString()");
		
		value = Grade.D.toLocaleString();
		System.out.println(value+"->Grade.D.toLocaleString()");
		//打印结果：79-70->Grade.C.toLocaleString()
		//一般->Grade.D.toLocaleString()
		
		String weekValue = WeekDay.MON.getValue();
		System.out.println(weekValue+"这是获取week的值");
		//打印结果：星期一  这是获取week的值
	}
	
	@org.junit.Test
	public void test()
	{
		//枚举类的常用方法：name valueOf  values
		
		String name = "B";
		
		Grade g = Grade.valueOf(Grade.class,name);//把字符串转成枚举对象
		System.out.println(g.name()+"获取枚举对象名称");  //获取枚举对象名称
		
		//得到一个枚举类的所有对象
		Grade gs[] = Grade.values();  //A B C D E
		for (Grade g1 : gs) 
		{
			System.out.println(g1.name() + "g1.name()");
		}
	}
}
