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
		 * 1.������ǰ��Servlet ��ӵ�е�Setter������ ���setter�������������������һ�µģ���������ĸ
		 * 2.���ݱ�����ÿһ��setter���������ƴ�request �����л�ȡ������
		 * 3.����setter��������ȡ���Ĳ������ý�ȥ
		 */
		//������ǰ��Servlet �����з����� ��Ҫʹ�÷������
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
