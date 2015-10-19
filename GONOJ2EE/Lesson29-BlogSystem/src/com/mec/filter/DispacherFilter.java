package com.mec.filter;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.mec.common.ISessionAware;
import com.mec.exception.ActionNoMappedException;
import com.mec.exception.UnknownActionResultException;
import com.mec.util.ServletUtil;

/**
 * Servlet Filter implementation class DispacherFilter
 */
public class DispacherFilter implements Filter {
	private static HashMap<String, Class<?>> actionClassMap;
	private HashMap<String, HashMap<String, String>> ationForwordMap;
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		/*
		 * 1. ���� ҵ����� ����
		 * 2. ���ҵ����ƶ����Ƿ�ʵ���� ISessionAware �ӿڣ����ʵ���ˣ� ���ȡ HttpSession �е� action_map �� Map ���󣬽��� set ��Action �����У�
		 * 3. �� request�е�����  set ��  ҵ����ƶ�����
		 * 4. ���� ҵ����ƶ���� execute ����
		 * 5. ���ҵ����ƶ����Ƿ�ʵ���� ISessionAware �ӿڣ����ʵ���ˣ������ҵ����ƶ���� get ������ ��get���� Map �������õ� HttpSession�����У�
		 * 6. ���� ҵ����ƶ���� get����������ȡ��������ƴ��Ϊ ��ת�õ� ������
		 * 7. ���� execute �����ķ���ֵ�ַ����ҵ�Ҫ��ת��Ŀ�ĵ�ַ�� Ȼ�������ת��
		 * */
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse res = (HttpServletResponse)response;
		String reqStr = req.getRequestURI();
		
		System.out.println(reqStr + "-----------------------------");
		/* String    Class   */
		String actionName = reqStr.substring(reqStr.lastIndexOf("/") + 1, reqStr.lastIndexOf("."));
		
		System.out.println("-------------------- actionName = " + actionName);
		try {
			Class<?> actionCls = this.actionClassMap.get(actionName);
			if(actionCls == null)
				throw new ActionNoMappedException("Action no mapped :" + actionCls);
			
			HashMap<String, String> forwordMap = this.ationForwordMap.get(actionName);
		
			Object action = actionCls.newInstance();
			ServletUtil.prepareRequestParam(action, req);
			
			if(action instanceof ISessionAware){
				ISessionAware sessionA = (ISessionAware)action;
				HttpSession session = req.getSession();
				HashMap<String, Object> map = (HashMap<String, Object>)session.getAttribute("action_map");
				if(map == null){
					map = new HashMap<String, Object>();
				}
				sessionA.setSession(map);
			}
			Method executeMethod = actionCls.getMethod("execute");
			String retStr = (String)executeMethod.invoke(action);
			if(action instanceof ISessionAware){
				ISessionAware sessionA = (ISessionAware)action;
				HttpSession session = req.getSession();
				HashMap<String, Object> map = sessionA.getSession();
				session.setAttribute("action_map", map);
			}
			String desUrl = forwordMap.get(retStr);
			
			if(desUrl == null){
				throw new UnknownActionResultException("Unkonw Result �� " + retStr + " for action " + actionName);
			}
			
			desUrl += "?" + ServletUtil.buildResponseParam(action);
			res.sendRedirect(desUrl);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ActionNoMappedException e) {
			e.printStackTrace();
		} catch (UnknownActionResultException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		actionClassMap = new  HashMap<String, Class<?>>();
		ationForwordMap = new HashMap<String, HashMap<String, String>>();
		
		InputStream actionFileIn = this.getClass().getResourceAsStream("../../../action.xml");
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document d = db.parse(actionFileIn);
			
			NodeList actionNodes = d.getElementsByTagName("action");
			
			for(int i = 0; i < actionNodes.getLength(); i++){
				Element ele =  (Element) actionNodes.item(i);
				String actionName = ele.getAttribute("name");
				String actionClassName = ele.getAttribute("class");
				actionClassMap.put(actionName, Class.forName(actionClassName));
				HashMap<String, String> forwordMap = new HashMap<String, String>();
				NodeList resultList = ele.getElementsByTagName("result");
				for(int j = 0; j < resultList.getLength(); j++){
					Element resEle =  (Element) resultList.item(j);
					String resultName = resEle.getAttribute("name");
					System.out.println("Servlet Init : -------- resultName = " + resultName);
					String url = resEle.getTextContent();
					forwordMap.put(resultName, url);
				}
				ationForwordMap.put(actionName, forwordMap);
			}
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
