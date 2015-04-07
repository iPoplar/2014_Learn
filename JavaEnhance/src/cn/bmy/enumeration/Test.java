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
		//��ӡ�����79-70->Grade.C.toLocaleString()
		//һ��->Grade.D.toLocaleString()
		
		String weekValue = WeekDay.MON.getValue();
		System.out.println(weekValue+"���ǻ�ȡweek��ֵ");
		//��ӡ���������һ  ���ǻ�ȡweek��ֵ
	}
	
	@org.junit.Test
	public void test()
	{
		//ö����ĳ��÷�����name valueOf  values
		
		String name = "B";
		
		Grade g = Grade.valueOf(Grade.class,name);//���ַ���ת��ö�ٶ���
		System.out.println(g.name()+"��ȡö�ٶ�������");  //��ȡö�ٶ�������
		
		//�õ�һ��ö��������ж���
		Grade gs[] = Grade.values();  //A B C D E
		for (Grade g1 : gs) 
		{
			System.out.println(g1.name() + "g1.name()");
		}
	}
}
