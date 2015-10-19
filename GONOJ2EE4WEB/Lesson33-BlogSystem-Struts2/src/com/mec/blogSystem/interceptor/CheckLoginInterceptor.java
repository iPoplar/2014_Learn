package com.mec.blogSystem.interceptor;

import java.util.Map;

import com.mec.blogSystem.action.BaseAction;
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
		Object action = arg0.getAction();
		
		if(action instanceof BaseAction){
			BaseAction bAction = (BaseAction)action;
			Map<String, Object> session = bAction.getSession();
			if(session == null){
				bAction.setErrorCode("SES001");
				bAction.setErrorMsg("ÉÐÎ´µÇÂ½£¬ÇëµÇÂ½¡£");
				return "FAILURE";
			}
			
			String userName = (String)session.get("userName");
			if(userName == null){
				bAction.setErrorCode("SES001");
				bAction.setErrorMsg("ÉÐÎ´µÇÂ½£¬ÇëµÇÂ½¡£");
				return "FAILURE";
			}
		}
		
		return arg0.invoke();
	}

}
