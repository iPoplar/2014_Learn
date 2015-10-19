package cn.bmy.ajax.action;

import java.util.Map;

public class BaseAction
{
	private Map<String, Object> session;
	private String errorCode;
	private String errorMsg;
	
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
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
	
	public BaseAction() {
		this.setErrorCode("REG001");
		this.setErrorMsg("SUCCESS");
	}
	
	public String execute() throws Exception
	{
		return null;
	}
	

}
