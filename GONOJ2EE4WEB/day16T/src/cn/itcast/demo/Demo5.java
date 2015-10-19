package cn.itcast.demo;

import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils_C3P0;

public class Demo5 {

	/**
	 *获取参数元信息
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		Connection conn = JdbcUtils_C3P0.getConnection();
		String sql = "select * from user wherer name=? and password=?";
		
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "aaaa");
		ParameterMetaData pm = st.getParameterMetaData();
		
		System.out.println(pm.getParameterCount());
		System.out.println(pm.getParameterType(1));

	}

}
