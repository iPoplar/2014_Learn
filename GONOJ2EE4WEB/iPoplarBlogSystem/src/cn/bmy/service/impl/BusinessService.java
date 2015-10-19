package cn.bmy.service.impl;

import java.util.List;

import cn.bmy.dao.impl.PoplarBlogDao;
import cn.bmy.domain.UserBlog;

public class BusinessService
{
	PoplarBlogDao dao = new PoplarBlogDao();
	
	public void addUserInfo(UserBlog u)
	{
		dao.addUserInfo(u);
	}
	
	public void addBlogInfo(UserBlog u)
	{
		dao.addBlogInfo(u);
	}
	
	public List<UserBlog> getUserInfo()
	{
		return dao.getLoginInfo();
	}
	
	public List<UserBlog> getBlogInfo()
	{
		return dao.getBlogInfo();
	}
}
