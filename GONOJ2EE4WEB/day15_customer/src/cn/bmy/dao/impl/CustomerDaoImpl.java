package cn.bmy.dao.impl;

import java.sql.SQLException;
import java.util.List;

import cn.bmy.domain.Customer;
import cn.bmy.exception.DaoException;
import cn.bmy.utils.BeanHandler;
import cn.bmy.utils.BeanListHandler;
import cn.bmy.utils.IntegerHandler;
import cn.bmy.utils.JdbcUtils;

public class CustomerDaoImpl 
{
	public void add(Customer c) throws DaoException
	{
		try
		{
			String sql = "insert into customer(id,name,gender,birthday,cellphone,email,preference,type,description) " +
			"values(?,?,?,?,?,?,?,?,?)";
			Object params[] = {c.getId(),c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription()};
			JdbcUtils.update(sql, params);
		} catch (SQLException e) {
			throw new DaoException(e);
		}
	}
	
	public void delete(String id) throws DaoException
	{
		try{
			String sql = "delete from customer where id=?";
			Object params[] ={id};
			JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	public void update(Customer c) throws DaoException{
		try{
		String sql = "update customer set name=?,gender=?,birthday=?,cellphone=?,email=?,preference=?,type=?,description=? where id=?";
		Object params[] = {c.getName(),c.getGender(),c.getBirthday(),c.getCellphone(),c.getEmail(),c.getPreference(),c.getType(),c.getDescription(),c.getId()};	
		JdbcUtils.update(sql, params);
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	public Customer find(String id) throws DaoException
	{
		try{
			String sql = "select * from customer where id=?";
			Object params[] ={id};
			return (Customer) JdbcUtils.query(sql, params, new BeanHandler(Customer.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}
	
	//获取分页数据
	public List<Customer> getPageData(int startindex, int pagesize) throws DaoException
	{
		try{
			String sql = "select * from customer limit ?,?";
			Object params[] = {startindex,pagesize};
			return (List<Customer>) JdbcUtils.query(sql, params, new BeanListHandler(Customer.class));
		}catch (Exception e) {
			 throw new DaoException(e);
		}
	}

	//得到总记录数
	public int getTotalrecord() throws DaoException
	{
		try{
			String sql = "select count(*) from customer";
			Object params[] = {};
			long l =  (Long) JdbcUtils.query(sql,params,new IntegerHandler());
			return (int)l;
		}catch (Exception e) {
			 throw new DaoException(e);
		}	
	}
}

