package cn.bmy.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Demo1 
{
	//获取数据库的驱动
	public static void main(String[] args) throws SQLException 
	{	
		String url = "jdbc:mysql://localhost:3306/day14";
		String username = "root";
		String password = "root";
		
		//1.加载驱动
		DriverManager.registerDriver(new com.mysql.jdbc.Driver());		
		
		//2.获取与数据库的链接
		Connection conn = DriverManager.getConnection(url, username, password);
		
		//3.获取用于向数据库发送sql语句的statement
		java.sql.Statement st = conn.createStatement();
		
		//4.向数据库发sql，并获取代表结果集的resultset
		String sql = "select id,name,password,email,birthday from users";
		ResultSet rs = st.executeQuery(sql);
		
		//5.a取出结果集中的数据
		while(rs.next())
		{
			System.out.println("id=" + rs.getObject("id"));
			System.out.println("name" + rs.getObject("name"));
			System.out.println("password=" + rs.getObject("password"));
			System.out.println("email=" + rs.getObject("email"));
			System.out.println("birthday=" + rs.getObject("birthday"));
		}
		//关闭连接，释放资源
		rs.close();
		st.close();
		conn.close();
		
		
	}
	

}
