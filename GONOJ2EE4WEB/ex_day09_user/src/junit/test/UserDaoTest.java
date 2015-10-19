package junit.test;

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
		user.setId("3333");
		user.setUsername("baby");
		user.setPassword("123");
		user.setEmail("cc@qq.com");
		user.setBirthday(new Date());
		
		UserDaoXmlImpl dao = new UserDaoXmlImpl();
		dao.add(user);
	}
	
	@Test
	public void testFind()
	{
		String username="bmy";
		UserDaoXmlImpl dao = new UserDaoXmlImpl();
		User user = dao.find("bmy");
		System.out.println(user);
		
		
	}
	
	@Test
	public void testFind2()
	{
		
		UserDao dao = new UserDaoXmlImpl();
		User user = dao.find("aaa","123");
		System.out.println(user);
	}
}
