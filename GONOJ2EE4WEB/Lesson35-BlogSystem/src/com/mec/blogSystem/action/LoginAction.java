package com.mec.blogSystem.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mec.blogSystem.common.Constants;

public class LoginAction extends BaseAction{
	private String userName;
	private String password;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		Class.forName(Constants.DB_DRIVER);
		System.out.println("password :" + this.password);
		Connection conn = DriverManager.getConnection(Constants.DB_URL);
		String sql = "select user_name, password from user_base_info where user_name = '"+
					userName
				+"'"; // 这是一个查询语句
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rst = stmt.executeQuery();
		
		if(!rst.next()){
			this.setErrorCode("LOG001");
			this.setErrorMsg("该用户名尚未注册");
			return "RETURN";
		}
		
		if(password == null || ! rst.getString("password").equals(password)){
			this.setErrorCode("LOG002");
			this.setErrorMsg("密码错误");
			return "RETURN";
		}
		
		this.getSession().put("userName", userName);
		return "RETURN";
	}

	@Override
	public String getErrorCode() {
		return super.getErrorCode();
	}

	@Override
	public String getErrorMsg() {
		return super.getErrorMsg();
	}

	public LoginAction(){
		super();
	}
}
