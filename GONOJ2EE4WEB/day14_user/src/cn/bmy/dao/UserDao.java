package cn.bmy.dao;

import cn.bmy.domain.User;

public interface UserDao {

	/*
	preparedStatement��statement������
	1��preparedStatement��statement�ĺ���
	2��preparedStatement���Է�ֹsqlע�������
	3��preparedStatement�����Զ����������sql������Ԥ���룬�Լ��������ѹ��
	 */
	void add(User user);

	User find(String username, String password);

	User find(String username);

}