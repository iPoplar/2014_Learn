package cn.bmy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bmy.domain.UserBlog;
import cn.bmy.exception.DaoException;
import cn.bmy.utils.JdbcUtils;

public class PoplarBlogDao 
{
	public void addUserInfo(UserBlog u)
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "insert into blog_user(user_name, password, sex, birthday, introduction) values(?,?,?,?,?)";
			
			st = conn.prepareStatement(sql);
			st.setString(1, u.getUserName());
			st.setString(2, u.getPassword());
			st.setString(3, u.getSex());
			st.setDate(4, new java.sql.Date(u.getBirthday().getTime()));
			st.setString(5, u.getIntroduction());
			
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public void addBlogInfo(UserBlog u)
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "insert into blog_info(user_name, blog) values (?,?)";
			st = conn.prepareStatement(sql);
			
			st.setString(1, u.getUserName());
			st.setString(2, u.getBlog());
			
			st.executeUpdate();
			
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public List<UserBlog> getLoginInfo()
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "select user_name, password from blog_user";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
		
			List list = new ArrayList();
			while(rs.next())
			{
				UserBlog u = new UserBlog();
				u.setUserName(rs.getString("user_name"));
				u.setPassword(rs.getString("password"));
				list.add(u);
			}
			return list.size()>0 ? list : null;
			
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{ 
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	public List<UserBlog> getBlogInfo()
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			conn = JdbcUtils.getConnection();
			String sql = "select user_name, blog from blog_info";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			
			List list = new ArrayList();
			while(rs.next())
			{
				UserBlog u = new UserBlog();
				u.setUserName(rs.getString("user_name"));
				u.setBlog(rs.getString("blog"));
				
				list.add(u);
			}
			return list.size()>0 ? list : null;
		} catch (Exception e) {
			throw new DaoException(e);
		}finally{
			JdbcUtils.release(conn, st, rs);
		}
		
	}
}
