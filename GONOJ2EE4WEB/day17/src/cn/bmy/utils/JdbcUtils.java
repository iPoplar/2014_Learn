package cn.bmy.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils 
{
	//����ӳ�
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
		//�������ӳ�
		return ds;
		
	}
}
