package cn.itcast.enumeration4;


public enum WeekDay {
	MON("星期一"),TUE("星期二"),WED("星期一"),THU("星期一"),FRI("星期一"),SAT("星期一"),SUN("星期一");
	
	private String value;
	private WeekDay(String value){
		this.value = value;
	}
	public String getValue() {
		return value;
	}
}

/*
enum WeekDay2 {
	MON{
		public  String toLocaleString();
		{
			return "星期一";
		}
	},TUE,WED,THU,FRI,SAT,SUN;
	
	public abstract String toLocaleString();
}
*/