package com.mec.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
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

import sun.security.jgss.spi.MechanismFactory;

/**
 * Servlet implementation class DispacherServlet
 */
public class DispacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static HashMap<String, Class> actionClassMap;
	private HashMap<String, HashMap<String, String>> ationForwordMap;
	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		actionClassMap = new  HashMap<String, Class>();
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 创建 业务控制 对象；
		 * 2. 检查业务控制对象是否实现了 ISessionAware 接口，如果实现了， 则获取 HttpSession 中的 action_map 的 Map 对象，将其 set 到Action 对象中；
		 * 3. 将 request中的数据  set 到  业务控制对象中
		 * 4. 调用 业务控制对象的 execute 方法
		 * 5. 检查业务控制对象是否实现了 ISessionAware 接口，如果实现了，则调用业务控制对象的 get 方法， 将get到的 Map 对象设置到 HttpSession对象中；
		 * 6. 调用 业务控制对象的 get方法，将获取到的数据拼接为 跳转用的 参数；
		 * 7. 根据 execute 方法的返回值字符串找到要跳转的目的地址， 然后进行跳转。
		 * */
		String reqStr = request.getRequestURI();
		
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
			ServletUtil.prepareRequestParam(action, request);
			
			if(action instanceof ISessionAware){
				ISessionAware sessionA = (ISessionAware)action;
				HttpSession session = request.getSession();
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
				HttpSession session = request.getSession();
				HashMap<String, Object> map = sessionA.getSession();
				session.setAttribute("action_map", map);
			}
			String desUrl = forwordMap.get(retStr);
			
			if(desUrl == null){
				throw new UnknownActionResultException("Unkonw Result ： " + retStr + " for action " + actionName);
			}
			
			desUrl += "?" + ServletUtil.buildResponseParam(action);
			response.sendRedirect(desUrl);
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

}
