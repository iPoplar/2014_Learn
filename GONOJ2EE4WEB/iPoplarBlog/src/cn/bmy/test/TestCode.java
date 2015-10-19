package cn.bmy.test;

import java.util.Date;

import org.junit.Test;

import cn.bmy.domain.UserBlog;
import cn.bmy.service.impl.BusinessService;

public class TestCode 
{
	@Test
	public void UserInfo()
	{
		BusinessService test = new BusinessService();
		UserBlog user = new UserBlog();
		user.setUserName("bmy");
		user.setPassword("2222");
		//user.setBirthday(new Date(19940812));
		user.setIntroduction("aaaaaaaaaaaa");		
		test.addUserInfo(user);
	}

	@Test
	public void FindUseInfo()
	{
		BusinessService user = new BusinessService();
		user.getLoginInfo();
	}
}
