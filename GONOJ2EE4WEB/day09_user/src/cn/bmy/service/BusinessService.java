package cn.bmy.service;

import cn.bmy.domain.User;
import cn.bmy.exception.UserExistException;

public interface BusinessService 
{
	//提供注册服务
	void registerUser(User user) throws UserExistException;

	User loginUser(String username, String password);

}