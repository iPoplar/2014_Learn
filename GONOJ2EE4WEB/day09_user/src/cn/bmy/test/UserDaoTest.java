package cn.bmy.test;

import java.util.Date;

import org.junit.Test;

import cn.bmy.dao.UserDao;
import cn.bmy.dao.impl.UserDaoXmlImpl;
import cn.bmy.domain.User;

public class UserDaoTest
{
	@Test
	public void testAdd()
	{
		User user = new User();
		user.setUsername("xxxxx");
		user.setId("2222");
		user.setPassword("123");
		user.setEmail("aa@qq.com");
		user.setBirthday(new Date());
		
		UserDao dao = new UserDaoXmlImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind()
	{
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("aaa","123");
		System.out.println(user);
	}
	
	@Test
	public void testFindByUsername()
	{
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("sssss");
		System.out.println(user);
	}
}
