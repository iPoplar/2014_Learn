package cn.bmy.daoImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;


import cn.bmy.domain.Department;
import cn.bmy.domain.Employee;
import cn.bmy.utils.JdbcUtils;

public class DepartmentDaoImpl{

	public void add(Department department) throws SQLException{
		
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		
		//1.ȡ��department����Ļ�����Ϣ���� department��
		String sql = "insert into department(id,name) values(?,?)";
		Object params[] = {department.getId(),department.getName()};
		qr.update(sql, params);
		
		//2. ȡ��department���������е�Ա����Ϣ������Ա����
		sql = "insert into employee(id,name,salary,department_id) values(?,?,?,?)";
		Set<Employee> set = department.getEmployees();
		Object params2[][] = new Object[set.size()][];
		
		int index = 0;
		for(Employee e : set){
			params2[index++] = new Object[]{e.getId(),e.getName(),e.getSalary(),department.getId()};
		}
		qr.batch(sql, params2);
		
		//3.����Ա���������У�˵��Ա����������
	}
	
	
	public Department find(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		
		//1.������ű����Ϣ������department������
		String sql = "select * from department where id=?";
		Department d = (Department) qr.query(sql, id, new BeanHandler(Department.class));
		
		
		//2.��������µ�����Ա����Ϣ������department����ά����Ա��������
		sql = "select id,name,salary from employee where department_id=?";
		List list = (List) qr.query(sql, id, new BeanListHandler(Employee.class));
		
		d.getEmployees().addAll(list);
		
		return d;
	}
	
}
