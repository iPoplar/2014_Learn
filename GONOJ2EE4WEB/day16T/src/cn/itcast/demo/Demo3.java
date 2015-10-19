package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.itcast.utils.JdbcUtils;

public class Demo3 {

	/**
	 * 设置事务隔离级别
	 * 写一个查询程序
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtils.getConnection();
			conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn.setAutoCommit(false);
			
			String sql = "select * from account where name='aaa'";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getFloat("money"));
			
			
			Thread.sleep(1000*10);
			
			rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getFloat("money"));
			
			Thread.sleep(1000*10);
			
			rs = st.executeQuery();
			rs.next();
			System.out.println(rs.getFloat("money"));
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}

}
