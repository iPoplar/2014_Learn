package cn.bmy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.bmy.domain.Role;
import cn.bmy.domain.User;
import cn.bmy.utils.JdbcUtils;

public class UserDao
{
	public void add(User user)
	{
		try 
		{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user(id,username,password) values(?,?,?)";
			Object Params[] = {user.getId(),user.getUsername(),user.getPassword()};
			
			runner.update(sql, Params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			return (User) runner.query(sql, id, new BeanHandler(User.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public User find(String username,String password){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object params[] = {username,password};
			return (User) runner.query(sql, params, new BeanHandler(User.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//得到所有用户
	public List getAll(){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user";
			return (List) runner.query(sql,  new BeanListHandler(User.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//得到用户角色
	public List<Role> getUserRoles(String user_id){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select r.* from user_role ur,role r where ur.user_id=? and ur.role_id=r.id";
			return (List<Role>) runner.query(sql, user_id, new BeanListHandler(Role.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//更新用户角色
	public void updateUserRole(User user,List<Role> roles){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			//删除用户拥有的所有角色
			String sql = "delete from user_role where user_id=?";
			runner.update(sql, user.getId());
			
			//更新用户的角色
			for(int i=0;i<roles.size();i++){
				Role role = roles.get(i);
				sql = "insert into user_role(user_id,role_id) values(?,?)";
				Object params[] = {user.getId(),role.getId()};
				runner.update(sql, params);
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
