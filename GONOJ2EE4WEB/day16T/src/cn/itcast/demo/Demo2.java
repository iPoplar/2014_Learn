package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;

import cn.itcast.utils.JdbcUtils;

public class Demo2 {


	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		Savepoint sp = null;
		
		try{
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);   //start transaction
			
			String sql1 = "update account set money=money-100 where name='aaa'";
			st = conn.prepareStatement(sql1);
			st.executeUpdate();
			
			sp = conn.setSavepoint();
			
			String sql2 = "update account set money=money+100 where name='bbb'";
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
			
			int x = 1/0;
			
			String sql3 = "update account set money=money+100 where name='ccc'"; 
			st = conn.prepareStatement(sql3);
			st.executeUpdate();
			
			conn.commit();
			
		}catch (Exception e) {
			try {
				conn.rollback(sp);
				conn.commit();  //回滚了要记得提交
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}

}
