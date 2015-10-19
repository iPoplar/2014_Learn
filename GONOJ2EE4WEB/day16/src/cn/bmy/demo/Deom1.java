package cn.bmy.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bmy.utils.JdbcUtils_C3P0;

/**
 模拟转账
  */
class Deom1 
{
	public static void main(String[] args) 
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils_C3P0.getConnection();
			conn.setAutoCommit(false);//start transaction
			
			String sql1 = "update account set money=money-100 where name='aaa'";
			st = conn.prepareStatement(sql1);
			st.executeUpdate();
			
			String sql2 = "update account set money=money+100 where name='bbb'";
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
			
			conn.commit();
			
			System.out.println("成功！");
			
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}finally
		{
			JdbcUtils_C3P0.release(conn, st, rs);
		}
		
	}

}
