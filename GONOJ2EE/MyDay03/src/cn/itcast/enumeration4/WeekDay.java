package cn.itcast.enumeration4;


public enum WeekDay {
	MON("����һ"),TUE("���ڶ�"),WED("����һ"),THU("����һ"),FRI("����һ"),SAT("����һ"),SUN("����һ");
	
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
			return "����һ";
		}
	},TUE,WED,THU,FRI,SAT,SUN;
	
	public abstract String toLocaleString();
}
*/