package cn.bmy.servlet.controller;

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

import cn.bmy.exception.ActionNoMappedException;
import cn.bmy.exception.UnknowActionResultException;
import cn.bmy.utils.ServletUtil;

public class DispacherServlet1 extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	private static HashMap<String, Class> actionClassMap;
	private HashMap<String, HashMap<String, String>> actionForwordMap;

	public void init(ServletConfig config)
	{
		actionClassMap = new HashMap<String, Class>();
		actionForwordMap = new HashMap<String, HashMap<String, String>>();
		
		InputStream actionFileIn = this.getClass().getResourceAsStream("../../../action.xml");
		//读取配置文件
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		
		try {
			db = dbf.newDocumentBuilder();
			Document d = db.parse(actionFileIn);
			
			NodeList actionNodes = d.getElementsByTagName("action");
			
			for(int i=0; i<actionNodes.getLength(); i++)
			{
				Element ele = (Element) actionNodes.item(i);
				String actionName = ele.getAttribute("name");
				String actionClassName = ele.getAttribute("class");
				actionClassMap.put(actionName, Class.forName(actionClassName));
				HashMap<String, String> forwordMap = new HashMap<String, String>();
				NodeList resultList = ele.getElementsByTagName("result");
				
				for(int j=0; j<resultList.getLength(); j++)
				{
					Element resEle = (Element) resultList.item(j);
					String resultName = resEle.getAttribute("name");
					System.out.println("Servlet Init : -------- resultName = " + resultName);
					String url = resEle.getTextContent();
					forwordMap.put(resultName, url);
				}
				
				actionForwordMap.put(actionName, forwordMap);
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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		/*
		 * 1.创建 业务控制对象 ；
		 * 2.检查业务控制对象中是否实现了ISessionAware接口，如果实现了，则获取HttpSession中的action_map的Map对象，
		 * 将其set到Action对象中；
		 * 3.将request对象set 到业务控制对象中；
		 * 4.调用业务控制对象中的excute方法；
		 * 5.检查业务控制对象是否实现了ISessionAware接口，如果实现了，则调用业务控制对象中的get方法，
		 * 将get到的Map对象 设置到HttpSession对象中；
		 * 6.调用业务控制对象中的get方法，将获取到的数据拼接为跳转用的参数；
		 * 7.根据execute方法的返回值字符串找到要跳转的目的地址，然后进行跳转。
		 * 
		 */
		String reqStr = request.getRequestURI();
		System.out.println(reqStr + "-----------------------------");
		String actionName = reqStr.substring(reqStr.lastIndexOf("/")+1, reqStr.lastIndexOf("."));
		System.out.println("-------------------- actionName = " + actionName);
		
		try {
			Class<?> actionCls = this.actionClassMap.get(actionName);
			if(actionCls == null)
			{
				throw new ActionNoMappedException("Action no mapped:"+ actionCls);
			}
			HashMap<String, String> forwardMap = this.actionForwordMap.get(actionCls);
			
			Object action = actionCls.newInstance();
			ServletUtil.prepareRequestParam(action, request);
			
			if(action instanceof ISessionAware)
			{
				ISessionAware sessionA = (ISessionAware) action;
				HttpSession session = request.getSession();
				HashMap<String, Object> map = (HashMap<String, Object>) session.getAttribute("action_map");
				if(map == null)
				{
					map = new HashMap<String, Object>();
				}
				sessionA.setSession(map);
			}
			Method executeMethod = actionCls.getMethod("execute");
			String retStr = (String) executeMethod.invoke(action);
			if(action instanceof ISessionAware)
			{
				ISessionAware sessionA = (ISessionAware) action;
				HttpSession session = request.getSession();
				HashMap<String, Object> map = sessionA.getSession();
				session.setAttribute("action_map", map);
			}
			String desUrl = forwardMap.get(retStr);
			
			if(desUrl == null)
			{
				throw new UnknowActionResultException("Unknow Result:" + retStr + "for action" + actionName);
			}
			
			desUrl += "?" + ServletUtil.buildResponseParam(action);
			response.sendRedirect(desUrl);
			
		} catch (ActionNoMappedException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (UnknowActionResultException e) {
			e.printStackTrace();
		}
		
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
