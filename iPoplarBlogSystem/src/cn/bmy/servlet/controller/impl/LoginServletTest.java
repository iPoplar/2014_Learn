package cn.bmy.servlet.controller.impl;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.bmy.servlet.controller.ISessionAware;
import cn.bmy.utils.ServletUtil;

public class LoginServletTest extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String userName;
	private String password;
	private HashMap<String, String> forwordMap;
	
	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public void init(ServletConfig cfg)
	{
		forwordMap = new HashMap<String, String>();
		Enumeration<String> paramNames = cfg.getInitParameterNames();
		while(paramNames.hasMoreElements())
		{
			String paramName = paramNames.nextElement();
			String paramValue = cfg.getInitParameter(paramName);
			forwordMap.put(paramName, paramValue);		
		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * 1.遍历当前的Servlet 所拥有的Setter方法， 这个setter方法的主名字与参数是一致的，除了首字母
		 * 2.根据遍历的每一个setter方法的名称从request 对象中获取参数；
		 * 3.调用setter方法，将取出的参数设置进去
		 */
		//遍历当前的Servlet 的所有方法， 需要使用反射机制
		LoginAction loginAction = new LoginAction();
		
		if(loginAction instanceof ISessionAware)
		{
			ISessionAware sessionA = (ISessionAware) loginAction;
			HttpSession session = request.getSession();
			HashMap<String, Object> map = (HashMap<String, Object>)session.getAttribute("action_map");
			if(map == null)
			{
				map = new HashMap<String, Object>();
			}
			sessionA.setSession(map);
		}
		
		ServletUtil.prepareRequestParam(loginAction, request);
		String resStr = loginAction.execute();
		
		if(loginAction instanceof ISessionAware)
		{
			ISessionAware sessionA = (ISessionAware)loginAction;
			HttpSession session = request.getSession();
			HashMap<String, Object> map = sessionA.getSession();
			session.setAttribute("action_map", map);
		}
		
		String desUrl = forwordMap.get(resStr);
		desUrl += "?" + ServletUtil.buildResponseParam(loginAction);
		response.sendRedirect(desUrl);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	
}
