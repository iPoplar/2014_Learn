package cn.bmy.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

public class Demo1 
{
	/**
	 * 用beanUtils操作bean
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 */
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException 
	{
		String name = "bmy";
		String password = "123";
		String age = "20";
		String email = "xiaobai@qq.com";
		String birthday = "1929-09-09";
		
		Student s = new Student();
		
		//注册转化器
		ConvertUtils.register(new Converter()
		{

			public Object convert(Class type, Object value)
			{//"1929-09-09"
				if(value == null)
				{
					return null;
				}
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date date = null;
				try 
				{
					date = format.parse((String)value);
				} catch (ParseException e) 
				{
					throw new ConversionException(e);
				}
				return date;
			}
			
		}, Date.class);
		BeanUtils.setProperty(s, "name", name);
		BeanUtils.setProperty(s, "password", password);
		BeanUtils.setProperty(s, "age", age);  //int
		BeanUtils.setProperty(s, "email", email);
		BeanUtils.setProperty(s, "birthday", birthday);  //string
		
		System.out.println(s.getAge());
		System.out.println(s.getBirthday());  //date

	}

}
