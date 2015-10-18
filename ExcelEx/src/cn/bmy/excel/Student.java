package cn.bmy.excel;

public class Student 
{
	/*
	 * 学生号/姓名/专业班级/联系方式/学习方向/受理小

		组/grade1/grade2/grade3/grade4/grade5/总评
	 */
	private String id;
	private String name;
	private String major;
	private String phone;
	private String direction;
	private String grade1;
	private String grade2;
	private String grade3;
	private String grade4;
	private String grade5;
	private String total ;
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getGrade1() {
		return grade1;
	}
	public void setGrade1(String grade1) {
		this.grade1 = grade1;
	}
	public String getGrade2() {
		return grade2;
	}
	public void setGrade2(String grade2) {
		this.grade2 = grade2;
	}
	public String getGrade3() {
		return grade3;
	}
	public void setGrade3(String grade3) {
		this.grade3 = grade3;
	}
	public String getGrade4() {
		return grade4;
	}
	public void setGrade4(String grade4) {
		this.grade4 = grade4;
	}
	public String getGrade5() {
		return grade5;
	}
	public void setGrade5(String grade5) {
		this.grade5 = grade5;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	

}
