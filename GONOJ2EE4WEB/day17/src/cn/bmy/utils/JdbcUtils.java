package cn.bmy.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils 
{
	//搭建连接池
	private static ComboPooledDataSource ds = null;
	static
	{
		ds = new ComboPooledDataSource("bmy");
	}
	
	public static Connection getConnection() throws SQLException
	{
		return ds.getConnection();		
	}

	public static DataSource getDataSource()
	{
		//返回连接池
		return ds;
		
	}
}
