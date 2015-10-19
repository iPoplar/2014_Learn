package cn.bmy.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtils 
{
	private static String driver = null;
	private static String url = null;
	private static String username = null;
	private static String password = null;
	
	//驱动只要加载一次就ol
	static 
	{
		try 
		{
			InputStream in = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");
			
			Class.forName(driver);//加载驱动
			
		} catch (Exception e) {
			throw new ExceptionInInitializerError(e); 
		}
	}

	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username, password);
		
	}
	
	public static void release(Connection conn,Statement st,ResultSet rs)
	{
		if(rs!=null)
			try {
				rs.close();
			} catch (SQLException e)
			{
				e.printStackTrace();
			}
			
			if(st!=null){
				try{
					st.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
				
			}
			
			if(conn!=null){
				try{
					conn.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
	}
	
}
