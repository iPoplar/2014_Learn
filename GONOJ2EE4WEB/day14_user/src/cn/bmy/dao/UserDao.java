package cn.bmy.dao;

import cn.bmy.domain.User;

public interface UserDao {

	/*
	preparedStatement和statement的区别
	1、preparedStatement是statement的孩子
	2、preparedStatement可以防止sql注入的问题
	3、preparedStatement它可以对它所代表的sql语句进行预编译，以减轻服务器压力
	 */
	void add(User user);

	User find(String username, String password);

	User find(String username);

}