package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils_C3P0;

public class Demo6 {

	/**
	 * 结果集的元数据
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		
		Connection conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from account";
		PreparedStatement st  = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		ResultSetMetaData metadata = rs.getMetaData();
		
		System.out.println(metadata.getColumnCount());
		System.out.println(metadata.getColumnName(1));
		
		
		
		

	}

}
