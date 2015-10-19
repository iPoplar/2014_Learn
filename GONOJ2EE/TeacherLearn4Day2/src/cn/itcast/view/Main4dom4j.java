package cn.itcast.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import cn.itcast.dao.StudentDao4dom4j;
import cn.itcast.domain.Student4dom4j;

public class Main4dom4j {

	public static void main(String[] args) throws IOException {
		
		System.out.println("添加学生 (a)  查找学生(b)  删除学生(c)");
		System.out.print("请输入操作类型：");
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String type = br.readLine();
		
		if(type.equalsIgnoreCase("a")){
			//添加学生
			
			try{
				System.out.print("请输入学生姓名：");
				String name = br.readLine();
				
				System.out.print("请输入学生准考证号：");
				String examid = br.readLine();
				
				System.out.print("请输入学生身份证号：");
				String idcard = br.readLine();
				
				System.out.print("请输入学生所在地：");
				String location = br.readLine();
				
				System.out.print("请输入学生成绩：");
				String grade = br.readLine();
				
				
				Student4dom4j student = new Student4dom4j();
				student.setExamid(examid);
				student.setGrade(Double.parseDouble(grade));
				student.setIdcard(idcard);
				student.setLocation(location);
				student.setName(name);
				
				StudentDao4dom4j dao = new StudentDao4dom4j();
				dao.add(student);
				System.out.println("恭喜，录入成功！！！");
			}catch (Exception e) {
				System.out.println("对不起，录入失败！！");
			}
			
			
		}else if(type.equalsIgnoreCase("b"))
		{
			//查找学生
			try
			{
				System.out.println("请输入查找学生的学生号：");
				String idcard = br.readLine();
				
				StudentDao4dom4j dao = new StudentDao4dom4j();
				dao.find(idcard);
				System.out.println("查找成功！");
			}catch(Exception e)
			{
				System.out.println("查找失败！");
				
			}
			
		}
		
		else if(type.equalsIgnoreCase("c"))
		{
			//删除学生
			try
			{
				System.out.println("请输入删除学生的姓名：");
				String name = br.readLine();
				
				StudentDao4dom4j dao = new StudentDao4dom4j();
				dao.delete(name);
				System.out.println("删除成功！！！");
				
			}catch(Exception e)
			{
				System.out.println("删除失败！！");
			}
			
		}
		else
		{
			System.out.println("不支持此类操作！！！");
		}	
	}
}

