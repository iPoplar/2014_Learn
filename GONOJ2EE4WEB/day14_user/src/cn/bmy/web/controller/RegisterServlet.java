package cn.bmy.web.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import cn.bmy.domain.User;
import cn.bmy.service.BusinessService;
import cn.bmy.service.impl.BusinessServiceImpl;
import cn.bmy.utils.WebUtils;
import cn.bmy.web.formbean.RegisterFormBean;

public class RegisterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException 
	{
		try
		{
			RegisterFormBean formbean = WebUtils.request2Bean(request, RegisterFormBean.class);
			
			//У���
			if(formbean.validate()==false)
			{
				request.setAttribute("formbean", formbean);
				request.getRequestDispatcher("/WEB-INF/jsp/register.jps").forward(request, response);
				
				return; 
			}
			
			//�ѱ���������䵽javaBean��
			User user = new User();
			
			//ע���ַ��������ڵ�ת����
			ConvertUtils.register(new DateLocaleConverter(), Date.class);
			BeanUtils.copyProperties(user, formbean);
			user.setId(WebUtils.makeId());
			BusinessService service = new BusinessServiceImpl();
			service.registerUser(user);
			
			request.setAttribute("message", "ע��ɹ�����");
			request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request, response);
			
			
		} catch (Exception e) //��̨��¼�쳣
		{
			request.setAttribute("message", "�Բ���ע��ʧ�� ������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
