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
		
		//1.取出department对象的基本信息存在 department表
		String sql = "insert into department(id,name) values(?,?)";
		Object params[] = {department.getId(),department.getName()};
		qr.update(sql, params);
		
		//2. 取出department对象中所有的员工信息，存在员工表
		sql = "insert into employee(id,name,salary,department_id) values(?,?,?,?)";
		Set<Employee> set = department.getEmployees();
		Object params2[][] = new Object[set.size()][];
		
		int index = 0;
		for(Employee e : set){
			params2[index++] = new Object[]{e.getId(),e.getName(),e.getSalary(),department.getId()};
		}
		qr.batch(sql, params2);
		
		//3.更新员工表的外键列，说明员工所属部门
	}
	
	
	public Department find(String id) throws SQLException{
		QueryRunner qr = new QueryRunner(JdbcUtils.getDataSource());
		
		//1.查出部门表的信息，存在department对象中
		String sql = "select * from department where id=?";
		Department d = (Department) qr.query(sql, id, new BeanHandler(Department.class));
		
		
		//2.查出部门下的所有员工信息，存在department对象维护的员工对象中
		sql = "select id,name,salary from employee where department_id=?";
		List list = (List) qr.query(sql, id, new BeanListHandler(Employee.class));
		
		d.getEmployees().addAll(list);
		
		return d;
	}
	
}
