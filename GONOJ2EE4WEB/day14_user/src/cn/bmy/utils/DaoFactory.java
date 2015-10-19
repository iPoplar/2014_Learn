package cn.bmy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.bmy.dao.UserDao;

public class DaoFactory 
{
	private UserDao userdao = null;
	
	private DaoFactory()	//ȷ��ִ����һ��
	{
		try 
		{
			//dao.properties�зŵ�dao���ݴ���java�����·��
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			//�õ�ʵ����������
			String daoClassName = prop.getProperty("userdao");
			//����ʵ��  ��������
			userdao = (UserDao) Class.forName(daoClassName).newInstance();
		} catch (Exception e) 
		{
			throw new RuntimeException(e);
		}
		
	}
	
	private static final DaoFactory instance = new DaoFactory();
	
	public static DaoFactory getInstace()
	{
		return instance;
	}
	
	public UserDao createUserDao()
	{
		return userdao;
	}

}
