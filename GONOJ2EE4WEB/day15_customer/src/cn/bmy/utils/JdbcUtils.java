package cn.bmy.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
			
			Class.forName(driver);
		} catch (Exception e) 
		{
			throw new ExceptionInInitializerError(e);
		}
	}

	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection(url, username,password);
	}
	
	public static void release(Connection conn, Statement st,ResultSet rs)
	{
		if (rs != null) {
			try {
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			rs = null;

		}
		if (st != null) {
			try {
				st.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void update(String sql, Object params[]) throws SQLException
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0; i<params.length;i++)
			{
				st.setObject(i+1, params[i]);
			}
			st.executeUpdate();
			
		} finally
		{
			release(conn,st,rs);
		}
	}
	
	//替换所有dao中的查询  	策略模式
	public static Object query(String sql, Object params[],ResultSetHandler rsh) throws SQLException
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			st = conn.prepareStatement(sql);
			for(int i=0;i<params.length;i++){
				st.setObject(i+1, params[i]);
			}
			rs = st.executeQuery();
			return rsh.handler(rs);
			
		}finally{
			release(conn, st, rs);
		}
	}
		
}
	

