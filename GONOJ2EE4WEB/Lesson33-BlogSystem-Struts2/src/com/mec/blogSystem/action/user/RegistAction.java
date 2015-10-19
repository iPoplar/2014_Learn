package com.mec.blogSystem.action.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mec.blogSystem.action.BaseAction;
import com.mec.blogSystem.common.Constants;
import com.opensymphony.xwork2.Action;

public class RegistAction extends BaseAction{
	private String userName;
	private String password;
	private String sex;
	private String age;
	private String introduction;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Override
	public String execute() throws Exception {
		Connection conn;
		
		Class.forName(Constants.DB_DRIVER);
		conn = DriverManager.getConnection(Constants.DB_URL);
		String sql = "select user_name from user_base_info where user_name = '"+ userName +"'";
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rst = stmt.executeQuery();
		
		if(rst.next()){
			this.setErrorCode("REG001");
			this.setErrorMsg("该用户名已被占用");
			return "FAILURE";
		}
		
		sql = "insert into user_base_info (user_name, password, sex, age, introduction) "
				+ "values ('"+ userName +"', '" + password + "', "+ "male".equals(sex) +", "+ 
				new Integer(age) +", '"+ introduction + "')";
		stmt = conn.prepareStatement(sql);
		stmt.execute();
		return "SUCCESS";
	}
	
	public RegistAction(){
		super();
	}
}
