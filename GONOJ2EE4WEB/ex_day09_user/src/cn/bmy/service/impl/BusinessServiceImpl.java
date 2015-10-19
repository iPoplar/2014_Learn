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
			//�����ױ���ʱ�쳣��ԭ����������һ�����������쳣
			throw new UserExistException("ע�����û��Ѵ���!!!");
		}

		dao.add(user);
	}

	//�ṩ�û���¼
	public User login(String username,String password)
	{
		return dao.find(username, password); 
	}
}
