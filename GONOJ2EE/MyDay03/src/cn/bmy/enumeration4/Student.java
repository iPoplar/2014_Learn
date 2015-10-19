package cn.bmy.enumeration4;

public class Student 
{
	private String name;
	private Grade grade;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Grade getGrade() {
		return grade;
	}
	public void setGrade(Grade grade) {
		this.grade = grade;
	}

}
enum Grade
{
	A("100-90") {
		public String toLocaleString()
		{
			return "”≈";
		}
	},B("89-80"){
		public String toLocaleString(){
			return "¡º";
		}
	
	},C("79-70")
	{
		public String toLocaleString(){
			return "÷–";
		}
	}	
	,D("69-60")
	{
		public String toLocaleString(){
			return "“ª∞„";
		}
	
	}	
	,E("59-0")  
	{
		public String toLocaleString(){
			return "≤Ó";
		}
	
	};
	private String value;
	private Grade(String value)
	{
		this.value = value;
	}
	public String getValue()
	{
		return value;
	}
	
	public abstract String toLocaleString();
}