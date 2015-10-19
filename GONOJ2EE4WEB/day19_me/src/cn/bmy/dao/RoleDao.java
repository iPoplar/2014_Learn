package cn.bmy.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.bmy.domain.Privilege;
import cn.bmy.domain.Role;
import cn.bmy.utils.JdbcUtils;

public class RoleDao 
{
	public void add(Role role)
	{
		try {
			QueryRunner runner  = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into role(id,name,description)values(?,?,?)";
			Object params[] = {role.getId(),role.getName(),role.getDescription()};
			runner.update(sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Role find(String id)
	{
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role where id=?";
			return (Role) runner.query(sql, id, new BeanHandler(Role.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public List<Privilege> getRolePrivileges(String role_id)
	{
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select p.* from role_privilege rp,privilege p where role_id=? and rp.privilege_id=p.id";
			
			return (List<Privilege>) runner.query(sql, role_id, new BeanListHandler(Privilege.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	//�õ����н�ɫ
	public List<Role> getAll()
	{
		try 
		{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from role";
			
			return (List<Role>) runner.query(sql, new BeanListHandler(Role.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	//Ϊĳ����ɫ��Ȩ
	public void updateRolePrivilege(Role role,List<Privilege> Privileges)
	{
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			//��ɾ����ɫӵ�е�Ȩ��
			String sql = "delete from role_privilege where role_id=?";
			runner.update(sql, role.getId());
			
			//����ɫ�����µ�Ȩ��
			for(Privilege p : Privileges){
				sql = "insert into role_privilege(role_id,privilege_id) values(?,?)";
				Object params[] = {role.getId(),p.getId()};
				runner.update(sql, params);
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	

}
