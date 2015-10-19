package com.mec.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

public class ServletUtil {
	public static void prepareRequestParam(Object servlet, HttpServletRequest request){
		Class<?> servletCls = servlet.getClass();
		Method[] methods = servletCls.getMethods();
		for(int i = 0; i < methods.length; i++){
			String methodName = methods[i].getName();
			Class<?>[] paramsType = methods[i].getParameterTypes();
			System.out.println("methodName = " + methodName);
			System.out.println("paramsType.length = " + paramsType.length);
			int flag = methodName.indexOf("set");
			if(flag == 0 && paramsType.length == 1 && paramsType[0].equals(String.class)){
				System.out.println("methodName = " + methodName);
				String paramName = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
				String paramValue = request.getParameter(paramName);
				try {
					methods[i].invoke(servlet, paramValue);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String buildResponseParam(Object obj){
		String retStr = "";
		Class cls = obj.getClass();
		
		Method[] methods = cls.getMethods();
		for(int i = 0; i < methods.length; i++){
			String methodName = methods[i].getName();
			int flag = methodName.indexOf("get");
			Class rt = methods[i].getReturnType();
			if(flag == 0 && rt.equals(String.class)){
				try {
					String value = (String)methods[i].invoke(obj);
					String name = methodName.substring(3, 4).toLowerCase() + methodName.substring(4);
					retStr += name + "=" + value + "&";
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					e.printStackTrace();
				}
			}
		}
		if(retStr.length() > 0)
			retStr.substring(0, retStr.lastIndexOf("&"));
		
		return retStr;
	}
}
