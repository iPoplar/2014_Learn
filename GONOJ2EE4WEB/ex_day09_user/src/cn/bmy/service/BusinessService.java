package cn.bmy.service;

import cn.bmy.domain.User;
import cn.bmy.exception.UserExistException;

public interface BusinessService {

	//�ṩע�����
	void registerUser(User user) throws UserExistException;

	//�ṩ�û���¼
	User login(String username, String password);

}