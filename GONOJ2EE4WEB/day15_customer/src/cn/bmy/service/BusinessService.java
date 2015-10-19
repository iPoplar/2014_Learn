package cn.bmy.service;

import java.util.List;

import cn.bmy.dao.impl.CustomerDaoImpl;
import cn.bmy.domain.Customer;
import cn.bmy.domain.Page;
import cn.bmy.exception.DaoException;

public class BusinessService 
{
	CustomerDaoImpl dao = new CustomerDaoImpl();
	
	public void addCustomer(Customer customer) throws DaoException
	{
		dao.add(customer);
	}

	public Page getPageData(String pagenum, String url) throws DaoException
	{
		int totalrecord = dao.getTotalrecord();
		
		if(pagenum == null)
		{
			//代表用户想看第一页的数据
			Page page = new Page(totalrecord ,1);//算出总页数，以及用户想看的页从数据库哪个地方开始取
			List list = dao.getPageData(page.getStartindex(),page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			
			return page;
		}else
		{
			//代表用户想看指定的页
			Page page = new Page(totalrecord,Integer.parseInt(pagenum));
			List list = dao.getPageData(page.getStartindex(), page.getPagesize());
			page.setList(list);
			page.setUrl(url);
			
			return page;
		}
	}
	
	public Customer findCustomer(String id) throws DaoException {
		return dao.find(id);
		
	}

	public void updateCustomer(Customer c) throws DaoException {
		dao.update(c);
	}

	public void deleteCustomer(String id) throws DaoException {
		dao.delete(id);
		
	}
}
