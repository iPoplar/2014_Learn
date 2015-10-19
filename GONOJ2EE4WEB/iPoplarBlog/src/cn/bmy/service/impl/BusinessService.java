package cn.bmy.service.impl;

import java.util.List;

import cn.bmy.dao.impl.PoplarBlogDao;
import cn.bmy.domain.UserBlog;

public class BusinessService 
{
	PoplarBlogDao dao = new PoplarBlogDao();
	
	public void addUserInfo(UserBlog user)
	{
		dao.addUserInfo(user);
	}
	
	public void addBlogInfo(UserBlog blog)
	{
		dao.addBlogInfo(blog);
	}
	
	public List<UserBlog> getLoginInfo()
	{
		return dao.getLoginInfo();
	}
	
	public List<UserBlog> getBlogInfo()
	{
		return dao.getBlogInfo();
	}
}
