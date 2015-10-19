package cn.bmy.dao;


import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.bmy.domain.Privilege;
import cn.bmy.utils.JdbcUtils;

public class PrivilegeDao 
{
	//添加权限
	public void add(Privilege p)
	{
	 try
	 	{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into privilege(id,name,description) values(?,?,?)";
			Object params[] = {p.getId(),p.getName(),p.getDescription()};
			runner.update(sql, params);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	//查找权限
	public Privilege find(String id)
	{
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege where id = ?";
		
			return (Privilege) runner.query(sql, id, new BeanHandler(Privilege.class));
		} catch (SQLException e) 
		{
			throw new RuntimeException(e);
		}
	}

	//得到所有权限
	public List<Privilege> getAll(){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from privilege";
			return (List<Privilege>) runner.query(sql, new BeanListHandler(Privilege.class));
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
