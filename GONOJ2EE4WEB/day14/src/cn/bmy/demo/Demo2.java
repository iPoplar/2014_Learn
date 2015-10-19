package cn.bmy.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2 
{
	/**
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * 
	 */
	public static void main(String[] args) throws SQLException, ClassNotFoundException 
	{
		String url = "jdbc:mysql://localhost:3306/day14";
		String username = "root";
		String password = "root";
		
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		
		try 
		{
			//1.���������������Ƽ��ķ�ʽ��
			Class.forName("com.mysql.jdbc.Driver");
			
			//2.��ȡ�����ݿ������
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("����conn"+conn);
			
			//3.��ȡ���������ݿⷢ��sql����statement
			st = conn.createStatement();
			
			//4.�����ݿⷢsql������ȡ����������resultset
			String sql = "select id,name,password,email,birthday from users";
			rs = st.executeQuery(sql);
			
			//5.ȡ�������������
			while(rs.next())
			{
				System.out.println("id=" + rs.getObject("id"));
				System.out.println("name=" + rs.getObject("name"));
				System.out.println("password=" + rs.getObject("password"));
				System.out.println("email=" + rs.getObject("email"));
				System.out.println("birthday=" + rs.getObject("birthday"));
			}
			
			
		} finally
		{
			//6.�ر����ӣ��ͷ���Դ
			if(rs!=null)
			{
				rs.close();
			}
			rs = null;
			
			if(st!=null)
				st.close();
			if(conn!=null)
				conn.close();
		}
		
	}

}
