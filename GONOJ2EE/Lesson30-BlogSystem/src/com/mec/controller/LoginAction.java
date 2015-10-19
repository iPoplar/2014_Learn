package com.mec.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import com.mec.common.Constants;
import com.mec.common.ISessionAware;

public class LoginAction implements ISessionAware{
	private String userName;
	private String password;
	private HashMap<String, Object> session;
	private String errorCode;
	private String errorMsg;
	
	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String execute(){
		Connection conn = null;
		this.errorCode = "000000";
		this.errorMsg = "SUCCESS";
		try {
			System.out.println("-------------Login Action begin.--------------------");
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			
			String sql = "select user_name, password from user_base_info where user_name = '"+
						userName
					+"'"; // 这是一个查询语句
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			
			if(!rst.next()){
				//查无此人
				this.errorCode = "LOG001";
				this.errorMsg = "No person";
				return "FAILURE";
			}
			
			Thread.sleep(6000);
			
			if(!password.equals(rst.getString("password"))){
				//密码错误
				this.errorCode = "LOG002";
				this.errorMsg = "Password wrong";
				return "FAILURE";
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally{
			if(conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return "SUCCESS";
	}

	@Override
	public HashMap<String, Object> getSession() {
		return this.session;
	}

	@Override
	public void setSession(HashMap<String, Object> session) {
		this.session = session;
	}
	
}
