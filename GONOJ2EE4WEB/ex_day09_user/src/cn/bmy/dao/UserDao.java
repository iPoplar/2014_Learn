package cn.bmy.dao;

import cn.bmy.domain.User;

public interface UserDao {

	//通过找到的用户名和密码从数据库中提取数据封装的bean中
	User find(String username, String password);

	void add(User user);

	User find(String username);

}

