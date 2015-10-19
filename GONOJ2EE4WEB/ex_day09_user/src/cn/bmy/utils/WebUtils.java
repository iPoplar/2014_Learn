package cn.bmy.utils;

import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils 
{
	//��request�����е����������װ��bean�� 
	//***������߯����������<T> ��class�ȵ�
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
