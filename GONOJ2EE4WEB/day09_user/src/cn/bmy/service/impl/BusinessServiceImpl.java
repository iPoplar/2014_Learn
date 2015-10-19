package cn.bmy.service.impl;

import cn.bmy.dao.UserDao;
import cn.bmy.dao.impl.UserDaoXmlImpl;
import cn.bmy.domain.User;
import cn.bmy.exception.UserExistException;
import cn.bmy.service.BusinessService;

public class BusinessServiceImpl implements BusinessService
{
	UserDao dao = new UserDaoXmlImpl();
	
	//提供注册服务
	public void registerUser(User user) throws UserExistException
	{
		if(dao.find(user.getUsername())!=null)
		{
			//checked exception 
			//unchecked exception
			//这里抛编译时异常的原因：是我想上一层程序处理这个异常，以给用户一个友好提示
			throw new UserExistException("注册的用户名已存在！！！");
		}
		
		dao.add(user);
	}
	
	public User loginUser(String username,String password)
	{
		return dao.find(username, password);		
	}

}
