package cn.bmy.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import cn.bmy.dao.UserDao;

public class DaoFactory 
{
	private UserDao userdao = null;
	
	private DaoFactory()	//确保执行了一次
	{
		try 
		{
			//dao.properties中放的dao数据处理java程序的路径
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
			Properties prop = new Properties();
			prop.load(in);
			
			//得到实例化的类名
			String daoClassName = prop.getProperty("userdao");
			//创建实例  完整类名
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
