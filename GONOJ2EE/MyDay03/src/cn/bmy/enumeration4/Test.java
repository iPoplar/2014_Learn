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
		//ö�ٵĳ��÷���:name valueOf values
		
		String name = "B";
		
		Grade g = Grade.valueOf(Grade.class,name);//���ַ���ת��ö�ٶ���
		
		System.out.println(g.name());//��ȡö�ٶ�������
		
		//�õ�һ��ö��������ж���
		Grade gs[] = Grade.values();//A B C D E
		for(Grade g1 : gs)
		{
			System.out.println(g1.name());
		}
		
	}

}
