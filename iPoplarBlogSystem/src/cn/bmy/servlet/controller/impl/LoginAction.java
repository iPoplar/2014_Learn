package cn.bmy.servlet.controller.impl;

import java.util.HashMap;

import cn.bmy.domain.UserBlog;
import cn.bmy.service.impl.BusinessService;
import cn.bmy.servlet.controller.ISessionAware;

public class LoginAction implements ISessionAware
{
	private String userName;
	private String password;
	private String errorCode;
	private String errorMsg;
	private HashMap<String, Object> session;
	
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
	
	
	public String execute()
	{
		
		BusinessService service = new BusinessService();
		UserBlog list = (UserBlog) service.getUserInfo();
		
		if(list != null)
		{
			this.errorCode = "LOG001";
			this.errorMsg = "welcome to iPoplarBlog";
			return "SUCCESS";
		}
		else
		{
			this.errorCode = "LOG002";
			this.errorMsg = "no person or password is wrong";
			return "FAILURE";
		}
	}
	
	public HashMap<String, Object> getSession() {
		return this.session;
	}
	
	public void setSession(HashMap<String, Object> session) {
		this.session = session;
		
	}
	

}
