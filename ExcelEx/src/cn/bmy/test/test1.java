package cn.bmy.test;

import java.util.ArrayList;
import java.util.List;

import cn.bmy.excel.ExcelEx;
import cn.bmy.excel.IStudentDao;
import cn.bmy.excel.Student;

public class test1 
{
	public static void main(String[] args) 
	{
		 System.out.println("OK");
		 IStudentDao Info = new IStudentDao();
		 List stu = Info.getBaseInfo();
		
	 	ExcelEx.writeExcelBo("F:\\����Ƽ�Э��2014����������.xls",stu);
		    
		System.err.println("Student OK!!!");
	}

}
