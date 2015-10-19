package cn.bmy.service.impl;

import java.util.List;

import cn.bmy.dao.impl.CustomerDaoImpl;
import cn.bmy.domain.Customer;
import cn.bmy.exception.DaoException;

public class BusinessService 
{
	CustomerDaoImpl dao = new CustomerDaoImpl();
	
	public void addCustomer(Customer customer) throws DaoException
	{
		dao.add(customer);		
	}

	public List<Customer> getAllCustomer() throws DaoException
	{
		return dao.getAll();
		
	}
}
