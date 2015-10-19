package cn.bmy.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.bmy.dao.UserDao;
import cn.bmy.domain.User;
import cn.bmy.exception.DaoException;
import cn.bmy.utils.JdbcUtils;

public class UserDaoJdbcImpl implements UserDao 
{
	/*
	preparedStatement��statement������
	1��preparedStatement��statement�ĺ���
	2��preparedStatement���Է�ֹsqlע�������
	3��preparedStatement�����Զ����������sql������Ԥ���룬�Լ��������ѹ��
	 */
	public void add(User user)
	{		

		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "insert into users(id,username,password,email,birthday) values(?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1, user.getId());//TODO ?
			st.setString(2, user.getUsername());
			st.setString(3, user.getPassword());
			st.setString(4, user.getEmail());
			st.setDate(5, new java.sql.Date(user.getBirthday().getTime())); 

		} catch (Exception e) 
		{
			throw new DaoException(e);
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public User find(String username, String password)
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			
			String sql = "select * from users where username=? and password=?";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			
			rs = st.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				
				return user;
			}
			return null;
		} catch (Exception e) 
		{
			throw new DaoException(e);
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public User find(String username)
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "select * from users where username=?";
			st = conn.prepareStatement(sql);
			st.setString(1, username);
			
			rs = st.executeQuery();
			if(rs.next())
			{
				User user = new User();
				user.setId(rs.getString("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setBirthday(rs.getDate("birthday"));
				return user;
			}
			return null;

			} catch (Exception e) {
			throw new DaoException(e);
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
			
		
	}
}
