package com.mec.ajax.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;

public class BaseAction implements Action, SessionAware{
	private Map<String, Object> session;
	private String errorCode;
	private String errorMsg;
	
	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	@Override
	public String execute() throws Exception {
		return null;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	public BaseAction(){
		this.setErrorCode("REG001");
		this.setErrorMsg("SUCCESS");
	}
}
