package cn.bmy.daoImpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import cn.bmy.dao.AccountDao;
import cn.bmy.domain.Account;
import cn.bmy.utils.JdbcUtils;

public class AccountDaoImpl implements AccountDao 
{
	private Connection conn = null;
	
	public AccountDaoImpl (Connection conn)
	{
		this.conn = conn;
	}

	public void update(Account account) throws SQLException
	{
		QueryRunner qr = new QueryRunner();
		String sql = "update account set name=?, money=? where id=?";
		Object params[] = {account.getName(),account.getMoney(),account.getId()};
		qr.update(JdbcUtils.getConnection(), sql, params);
	}

	public Account find(int id) throws SQLException
	{
		QueryRunner qr = new QueryRunner();
		String sql= "select * from account where id=?";
		return (Account) qr.query(JdbcUtils.getConnection(), sql,id,new BeanHandler(Account.class));
	}
}
