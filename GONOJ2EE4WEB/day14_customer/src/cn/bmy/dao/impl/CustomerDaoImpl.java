package cn.bmy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.bmy.domain.Customer;
import cn.bmy.exception.DaoException;
import cn.bmy.utils.JdbcUtils;

public class CustomerDaoImpl 
{
	public void add(Customer c) throws DaoException
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) values(?,?,?,?,?,?,?,?,?)";
			st = conn.prepareStatement(sql);
			st.setString(1,	c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getGender());
			st.setDate(4, new java.sql.Date(c.getBirthday().getTime()));
			st.setString(5, c.getCellphone());
			st.setString(6, c.getEmail());
			st.setString(7, c.getPreference());
			st.setString(8, c.getType());
			st.setString(9, c.getDescription());
			
			st.executeUpdate();
		} catch (Exception e) {
			throw new DaoException(e);
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
	//TODO update delete
	
	public Customer find(String id)
	{
		return null;
	}
	
	public List<Customer> getAll() throws DaoException
	{
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try 
		{
			conn = JdbcUtils.getConnection();
			String sql = "select * from customer";
			st = conn.prepareStatement(sql);
			rs = st.executeQuery();
			List list = new ArrayList();
			while(rs.next())
			{
				Customer c = new Customer();
				c.setBirthday(rs.getDate("birthday"));
				c.setCellphone(rs.getString("cellphone"));
				c.setDescription(rs.getString("description"));
				c.setEmail(rs.getString("email"));
				c.setGender(rs.getString("gender"));
				c.setId(rs.getString("id"));
				c.setName(rs.getString("name"));
				c.setPreference(rs.getString("preference"));
				c.setType(rs.getString("type"));
				
				list.add(c);				
			}
			
			return list.size()>0?list:null;
			
		} catch (Exception e) {
			throw new DaoException(e);
		}finally
		{
			JdbcUtils.release(conn, st, rs);
		}
	}
	
}
