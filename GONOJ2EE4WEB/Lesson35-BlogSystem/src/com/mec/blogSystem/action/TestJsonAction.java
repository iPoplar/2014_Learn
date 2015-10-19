package com.mec.blogSystem.action;

import java.util.ArrayList;

import org.apache.tomcat.jni.User;

import com.mec.blogSystem.model.UserInfo;
import com.opensymphony.xwork2.Action;

public class TestJsonAction implements Action {
	private String errorCode;
	private String errorMsg;
	private UserInfo user;
	private ArrayList<UserInfo> userList;
	
	private String userName;
	private String password;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public UserInfo getUser() {
		return user;
	}

	public ArrayList<UserInfo> getUserList() {
		return userList;
	}

	@Override
	public String execute() throws Exception {
		this.userList = new ArrayList<UserInfo>();
		this.userList.add(new UserInfo("SupserMan", "123456"));
		this.user = new UserInfo("wangxh", "111111");
		
		System.out.println("User Name is :" + this.userName);
		System.out.println("Password is : " + this.password);
		
		return "SUCCESS";
	}
}
