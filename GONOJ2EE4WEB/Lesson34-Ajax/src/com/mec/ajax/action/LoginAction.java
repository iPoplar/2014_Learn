package com.mec.ajax.action;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;

import com.mec.ajax.common.Constants;

public class LoginAction extends BaseAction{
	private String userName;
	private String password;
	
	private Map<String, Object> session;

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String execute() throws Exception {
		Class.forName(Constants.DB_DRIVER);
		
		Thread.sleep(10000);
		
		Connection conn = DriverManager.getConnection(Constants.DB_URL);
		
		String sql = "select user_name, password from user_base_info where user_name = '"+
					userName
				+"'"; // 这是一个查询语句
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet rst = stmt.executeQuery();
		
		if(!rst.next()){
			//查无此人
			this.setErrorCode("LOG001");
			this.setErrorMsg("该用户名尚未注册");
			return "FAILURE";
		}
		
		if(!password.equals(rst.getString("password"))){
			//密码错误
			this.setErrorCode("LOG002");
			this.setErrorMsg("密码错误");
			return "FAILURE";
		}
		
		//登陆成功
		/*HttpSession session = request.getSession();
		session.setAttribute("userName", userName);*/
		this.session.put("userName", userName);
		return "SUCCESS";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}
	
	public LoginAction(){
		super();
	}
}
