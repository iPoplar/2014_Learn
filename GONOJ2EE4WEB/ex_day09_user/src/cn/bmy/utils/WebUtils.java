package cn.bmy.utils;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils 
{
	//把request对象中的请求参数封装到bean中 
	//***这个设计忒棒，很优雅<T> ，class等等
	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz)
	{
		try {
			T bean = clazz.newInstance();
			Enumeration e = request.getParameterNames();
			while(e.hasMoreElements())
			{
				String name = (String) e.nextElement();
				String value = (String) request.getParameter(name);
				BeanUtils.setProperty(bean, name, value);
			}
			return bean;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String makeId()
	{
		return UUID.randomUUID().toString();
	}
	
}
