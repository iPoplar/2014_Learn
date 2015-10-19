package cn.bmy.service.impl;

import org.omg.CORBA.UserException;

import cn.bmy.dao.UserDao;
import cn.bmy.domain.User;
import cn.bmy.exception.UserExistException;
import cn.bmy.service.BusinessService;
import cn.bmy.utils.DaoFactory;



public class BusinessServiceImpl implements BusinessService
{
	UserDao dao = DaoFactory.getInstace().createUserDao();
	
	//�ṩע�����
	public void registerUser(User user) throws UserExistException
	{
		if(dao.find(user.getUsername())!=null)
		{
			throw new UserExistException("ע����û����Ѵ���!!!");
		}
		
		dao.add(user);
	}
	
	public User loginUser(String username, String password)
	{
		return dao.find(username, password);
	}

}
