package cn.itcast.demo;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils_C3P0;

public class Demo4 {

	/**
	 * 获取数据库的元信息
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		Connection conn = JdbcUtils_C3P0.getConnection();  //5.0.12
		
		DatabaseMetaData metadata = conn.getMetaData();
		System.out.println(metadata.getDatabaseProductName());
		System.out.println(metadata.getDriverName());
		
	}

}
