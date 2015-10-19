package cn.bmy.excel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class IStudentDao 
{
	/**
	 * 获取 学生号/姓名/专业班级/联系方式/学习方式
	 */
	public List getBaseInfo()
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		Student c = new Student();
		List<Student> listt = new ArrayList<Student>();
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "select * from man";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();			
			
			while(rs.next())
			{
				c.setName(rs.getString("username"));
				c.setId(rs.getString("id"));
				c.setMajor(rs.getString("class"));
				c.setPhone(rs.getString("phone"));				
				c.setDirection(rs.getString("directionid"));
				
				System.out.println(rs.getString("username"));
				System.out.println(c.getMajor());
				System.out.println(c.getPhone());
				System.out.println(c.getDirection());
				
				 
		    	Student student = new Student();
		    	student.setId(c.getId());
		    	student.setName(c.getName());
		    	student.setMajor(c.getMajor());
		    	student.setPhone(c.getPhone());
		    	
		    	listt.add(student);
				
			}
			
		} catch (Exception e) {
			
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
		return listt;
	}
	
	/*
	 * 受理小组/grade1/grade2/grade3/grade4/grade5/总评
	 */
	public void getreport()
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			
			conn = JdbcUtils.getConnection();
			
			String sql = "select name from direction where id=(select directionid from man where id = '04131040'";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();			
			//Student c = new Student();
			System.out.println("sdfljlskjgsdfhgfs+23333333333");
			while(rs.next())
			{
				System.out.println("sdfljlskjgsdfhgfs");
				System.out.println(rs.getString("name"));
			}
			
		} catch (Exception e) {
			
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
	
	}
	
	public static void main(String[] args) 
	{
		IStudentDao stu = new IStudentDao();
		stu.getBaseInfo();
		//stu.getreport();
	}
}
