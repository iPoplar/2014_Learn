package cn.itcast.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.itcast.dao.PrivilegeDao;
import cn.itcast.dao.RoleDao;
import cn.itcast.dao.UserDao;
import cn.itcast.domain.Privilege;
import cn.itcast.domain.Role;
import cn.itcast.domain.User;

//��web���ṩ����Ȩ����ͬ�ķ���
public class SecurityService {

	private PrivilegeDao pdao = new PrivilegeDao();
	private RoleDao rdao = new RoleDao();
	private UserDao udao = new UserDao();
	
	//��web���ṩ���Ȩ�޵ķ���
	public void addPrivilege(Privilege p){
		pdao.add(p);
	}
	
	//��web���ṩ����Ȩ�޵ķ���
	public Privilege findPrivilege(String id){
		return pdao.find(id);
	}
	
	//��web���ṩ�õ�����Ȩ�޵ķ���
	public List<Privilege> getAllPrivilege(){
		return pdao.getAll();
	}
	
	
	//��web���ṩ��ӽ�ɫ�ķ���
	public void addRole(Role role){
		rdao.add(role);
	}
	
	//�õ�ĳһ����ɫ
	public Role findRole(String id){
		return rdao.find(id);
	}
	
	//�õ���ɫ����Ȩ��
	public List<Privilege> getRolePrivileges(String role_id){
		return rdao.getRolePrivileges(role_id);
	}

	//�õ����н�ɫ
	public List<Role> getAllRole(){
		return rdao.getAll();
	}

	
	//���½�ɫ��Ȩ��
	public void updateRolePrivilege(String role_id, String[] privilege_ids) {
		Role role = rdao.find(role_id);
		List list = new ArrayList();
		
		for(int i=0;privilege_ids!=null && i<privilege_ids.length;i++){
			Privilege p = pdao.find(privilege_ids[i]);
			list.add(p);
		}
		rdao.updateRolePrivilege(role, list);
	}
	
	//����û�
	public void addUser(User user){
		udao.add(user);
	}
	
	//�����û�
	public User findUser(String user_id){
		return udao.find(user_id);
	}
	
	//�õ������û�
	public List<User> getAllUser(){
		return udao.getAll();
	}
	
	
	//�õ�ĳ���û�ӵ�еĽ�ɫ
	public List<Role> getUserRoles(String user_id){
		return udao.getUserRoles(user_id);
	}
	
	//�����û��Ľ�ɫ
	public void updateUserRole(String user_id,String[] role_ids){
		User user = udao.find(user_id);
		List list = new ArrayList();
		
		for(int i=0;role_ids!=null && i<role_ids.length;i++){
			Role r = rdao.find(role_ids[i]);
			list.add(r);
		}
		udao.updateUserRole(user, list);
	}

	//�õ��û����е�Ȩ��
	public Set getUserAllPrivilege(String user_id) {
		
		Set allPrivilege = new HashSet();
		
		//�õ��û�ӵ�еĽ�ɫ
		List<Role> user_roles = udao.getUserRoles(user_id);
		
		//�õ���ɫӵ�е�Ȩ��
		for(Role r : user_roles){
			List role_privilege = rdao.getRolePrivileges(r.getId());
			allPrivilege.addAll(role_privilege);
		}
		
		return allPrivilege;
		
	}

	//��½
	public User login(String username, String password) {
		
		return udao.find(username, password);
	}
}
