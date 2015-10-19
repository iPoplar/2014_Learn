package cn.bmy.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Demo1 
{
	//��ȡ���ݿ������
	public static void main(String[] args) throws SQLException 
	{	
		String url = "jdbc:mysql://localhost:3306/day14";
		String username = "root";
		String password = "root";
		
		//1.��������
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());		
		
		//2.��ȡ�����ݿ������
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.��ȡ���������ݿⷢ��sql����statement
		java.sql.Statement st = conn.createStatement();
		
		//4.�����ݿⷢsql������ȡ����������resultset
		String sql = "select id,name,password,email,birthday from users";
		ResultSet rs = st.executeQuery(sql);
		
		//5.aȡ��������е�����
		while(rs.next())
		{
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
		}
		//�ر����ӣ��ͷ���Դ
		rs.close();
		st.close();
		conn.close();
		
		
	}
	

}
