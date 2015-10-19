package cn.itcast.demo;

import java.sql.SQLException;
import java.util.List;

import cn.itcast.dao.AccountDao;
import cn.itcast.domain.Account;

public class Demo7 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		
		AccountDao dao = new AccountDao();
		List list = dao.getAll();
		System.out.println(list.size());

	}

}
