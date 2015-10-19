package cn.bmy.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.bmy.dao.PrivilegeDao;
import cn.bmy.dao.RoleDao;
import cn.bmy.dao.UserDao;
import cn.bmy.domain.Privilege;
import cn.bmy.domain.Role;
import cn.bmy.domain.User;

public class SecurityService 
{
	private PrivilegeDao pdao = new PrivilegeDao();
	private RoleDao rdao = new RoleDao();
	private UserDao udao = new UserDao();
	
	//对web层提供添加权限的服务
	public void addPrivilege(Privilege p){
		pdao.add(p);
	}
	
	//对web层提供查找权限的服务
	public Privilege findPrivilege(String id){
		return pdao.find(id);
	}
	
	//对web层提供得到所有权限的服务
	public List<Privilege> getAllPrivilege(){
		return pdao.getAll();
	}

	//添加角色
	public void addRole(Role role)
	{
		rdao.add(role);
	}
	
	
	//得到摸一个角色
	public Role findRole(String id)
	{
		return (Role) rdao.getRolePrivileges(id);
	}
	
	//得到角色所有权限
	public List<Privilege>getRolePrivileges(String role_id)
	{
		return rdao.getRolePrivileges(role_id);
	}
	
	//得到所有角色
	public List<Role> getAllRole()
	{
		return rdao.getAll();
	}
	
	//更新角色的权限
	public void updateRolePrivilege(String role_id,String[] privilege_ids)
	{
		Role role = rdao.find(role_id);
		List list = new ArrayList();
		
		for(int i=0; privilege_ids!=null && i<privilege_ids.length;i++)
		{
			Privilege p = pdao.find(privilege_ids[i]);
			list.add(p);
		}
		rdao.updateRolePrivilege(role, list);
	}
	
	//添加用户
	public void addUser(User user)
	{
		udao.add(user);
	}
	
	//查找用户
	public User findUser(String user_id)
	{
		return udao.find(user_id);
	}
	
	//得到所有用户
	public List<User>getAllUser()
	{
		return udao.getAll();
	}
	
	//得到某个用户拥有的角色
	public List<Role> getUserRoles(String user_id)
	{
		return udao.getUserRoles(user_id);
	}
	
	//更新用户的角色
	public void updateUserRole(String user_id, String[] role_ids)
	{
		User user = udao.find(user_id);
		List list = new ArrayList();
		
		for(int i=0; role_ids!=null && i<role_ids.length;i++)
		{
			Role r = rdao.find(role_ids[i]);
			list.add(r);
		}
		udao.updateUserRole(user, list);
	}
	
	//得到用户所有的权限
	public Set getUserAllPrivilege(String user_id) {
		
		Set allPrivilege = new HashSet();
		
		//得到用户拥有的角色
		List<Role> user_roles = udao.getUserRoles(user_id);
		
		//得到角色拥有的权限
		for(Role r : user_roles){
			List role_privilege = rdao.getRolePrivileges(r.getId());
			allPrivilege.addAll(role_privilege);
		}
		
		return allPrivilege;
		
	}
	
	//登陆
	public User login(String username, String password)
	{
		return udao.find(username, password);
	}
}
