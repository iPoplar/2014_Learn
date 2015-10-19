package cn.bmy.service.impl;

import cn.bmy.dao.UserDao;
import cn.bmy.dao.impl.UserDaoXmlImpl;
import cn.bmy.domain.User;
import cn.bmy.exception.UserExistException;
import cn.bmy.service.BusinessService;

public class BusinessServiceImpl implements BusinessService
{
	UserDao dao = new UserDaoXmlImpl();
	
	//�ṩע�����
	public void registerUser(User user) throws UserExistException
	{
		if(dao.find(user.getUsername())!=null)
		{
			//checked exception 
			//unchecked exception
			//�����ױ���ʱ�쳣��ԭ����������һ�����������쳣���Ը��û�һ���Ѻ���ʾ
			throw new UserExistException("ע����û����Ѵ��ڣ�����");
		}
		
		dao.add(user);
	}
	
	public User loginUser(String username,String password)
	{
		return dao.find(username, password);		
	}

}
