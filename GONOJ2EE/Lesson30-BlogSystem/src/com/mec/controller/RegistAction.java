package com.mec.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mec.common.Constants;

public class RegistAction {
	private String userName;
	private String password;
	private String age;
	private String sex;
	private String introduction;
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
	public void setAge(String age) {
		this.age = age;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	
	public String execute(){
		Connection conn = null;
		try {
			Class.forName(Constants.DB_DRIVER);
			conn = DriverManager.getConnection(Constants.DB_URL);
			String sql = "select user_name from user_base_info where user_name = '"+ userName +"'";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rst = stmt.executeQuery();
			if(rst.next()){
				this.errorCode = "REG001";
				this.errorMsg = "该用户已存在";
				return "FAILURE";
			}
			sql = "insert into user_base_info (user_name, password, sex, age, introduction) "
					+ "values ('"+ userName +"', '" + password + "', "+ "male".equals(sex) +", "+ 
					new Integer(age) +", '"+ introduction + "')";
			stmt = conn.prepareStatement(sql);
			stmt.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return "SUCCESS";
	}
	
	public RegistAction(){
		this.errorCode = "000000";
		this.errorMsg = "SUCCESS";
	}
}
