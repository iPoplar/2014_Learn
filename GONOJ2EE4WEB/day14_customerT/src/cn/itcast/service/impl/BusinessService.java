package cn.itcast.service.impl;

import java.util.List;

import cn.itcast.dao.impl.CustomerDaoImpl;
import cn.itcast.domain.Customer;

public class BusinessService {

	CustomerDaoImpl dao = new CustomerDaoImpl();
	
	public void addCustomer(Customer customer){
		dao.add(customer);
	}
	
	public List<Customer> getAllCustomer(){
		return dao.getAll();
	}
	
}
