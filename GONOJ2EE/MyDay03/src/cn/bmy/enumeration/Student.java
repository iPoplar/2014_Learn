package cn.bmy.enumeration;

public class Student
{
	private String name;
	private String grade;//A B C D E 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	//��ö�ٷ�װ�������Ϣ����ö�ٶ���ӵ���Լ������ԣ�
	
}

enum Grade
{
	A("100-90"),B("89-80"),C("79-70"),D("69-60"),E("59-0");  
	//��Ӧ����Grade��Ķ���  //100-90 89-80
	private String value;
	private Grade(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return value;
	}
	
	//��̬���ģʽ
	enum Demo
	{
		//�� new demo
		demo;
	}
}


