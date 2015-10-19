package cn.itcast.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.JdbcUtils_C3P0;
import cn.itcast.utils.JdbcUtils_DBCP;

public class Demo1 {

	/**
	 * 模似转帐
	  
create table account(
	id int primary key auto_increment,
	name varchar(40),
	money float
)character set utf8 collate utf8_general_ci;

insert into account(name,money) values('aaa',1000);
insert into account(name,money) values('bbb',1000);
insert into account(name,money) values('ccc',1000);
	 
	 */
	public static void main(String[] args) {
		
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try{
			conn = JdbcUtils_C3P0.getConnection();
			conn.setAutoCommit(false);   //start transaction
			
			String sql1 = "update account set money=money-100 where name='aaa'";
			st = conn.prepareStatement(sql1);
			st.executeUpdate();
			
			
			String sql2 = "update account set money=money+100 where name='bbb'";
			st = conn.prepareStatement(sql2);
			st.executeUpdate();
			
			
			conn.commit();
			
			System.out.println("成功！！！");  //log4j
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			JdbcUtils_C3P0.release(conn, st, rs);
		}
		
	}

}
