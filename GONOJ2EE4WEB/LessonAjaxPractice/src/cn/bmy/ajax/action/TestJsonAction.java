package cn.bmy.ajax.action;

import java.util.ArrayList;

import com.mec.ajax.model.UserInfo;
import com.opensymphony.xwork2.Action;

public class TestJsonAction implements Action {
	
	private String errorCode;
	private String errorMsg;
	private UserInfo user;
	private ArrayList<UserInfo> userList;
	
	private String userName;
	private String password;

	public String execute() throws Exception {
		
		return null;
	}

}
