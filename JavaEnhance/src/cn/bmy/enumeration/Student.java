package cn.bmy.enumeration;

public class Student
{
	private String name;
	private Grade grade;
	
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public Grade getGrade() 
	{
		return grade;
	}
	public void setGrade(Grade grade) 
	{
		this.grade = grade;
	}
	
}

//如何让枚举对象拥有属性和各自的方法
enum Grade
{   //定义一个类
	A("100-90")
	{
		public String toLocaleString()
		{
			return "优";
		}
	},B("89-80")
	{
		public String toLocaleString()
		{
			return "良";
		}
	
	},C("79-70")
	{
		public String toLocaleString()
		{
			return "中";
		}
	}
	
	,D("69-60")
	{
		public String toLocaleString()
		{
			return "一般";
		}
	
	},E("59-0")  
	{
		public String toLocaleString()
		{
			return "差";
		}	
	};
	
	private String value;
	
	private Grade(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
	
	public abstract String toLocaleString();	
}

