package cn.bmy.dao;

import cn.bmy.domain.User;

public interface UserDao 
{
	User find(String username, String password);

	void add(User user);

	User find(String username);

}