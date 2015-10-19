package com.mec.blogSystem.result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.derby.tools.sysinfo;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.StrutsResultSupport;

import com.opensymphony.xwork2.ActionInvocation;

public class FirstResult extends StrutsResultSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2919912890701158830L;

	@Override
	protected void doExecute(String finalLocation, ActionInvocation invocation)
			throws Exception {
		System.out.println("Hash Code : " + this.hashCode());
		System.out.println("Our First Result Type .");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		System.out.println("finalLocation = " + finalLocation);
		request.getRequestDispatcher(finalLocation).forward(request, response);;
	}
	
	public FirstResult(){
		System.out.println("--- This is First Result Constructor. ---");
	}

}
