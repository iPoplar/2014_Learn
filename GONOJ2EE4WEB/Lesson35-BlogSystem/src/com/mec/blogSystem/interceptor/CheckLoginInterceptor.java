package com.mec.blogSystem.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.mec.blogSystem.action.BaseAction;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class CheckLoginInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1666864993162603867L;

	@Override
	public void destroy() {
	}

	@Override
	public void init() {
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		
		Map<String, Object> session =  ActionContext.getContext().getSession();
		Object action = arg0.getAction();
		if(session == null){
			if(action instanceof BaseAction){
				BaseAction act = (BaseAction)action;
				act.setErrorCode("SES001");
				act.setErrorMsg("δ��¼�����½");
			}
		}
		
		Object userName = session.get("userName");
		if(userName == null){
			
			if(action instanceof BaseAction){
				BaseAction act = (BaseAction)action;
				act.setErrorCode("SES001");
				act.setErrorMsg("δ��¼�����½");
			}
			return "RETURN";
		}
		return arg0.invoke();
	}
}
