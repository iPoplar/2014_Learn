package test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;

import org.junit.Test;

import cn.bmy.daomain.Student4dom4j;

public class Test1
{
		@Test
		public void test4() throws Exception{
			
			Class clazz = Class.forName("cn.bmy.daoImpl.DaoImpl");  
			
			 Method[] methods = clazz.getDeclaredMethods();
		        for (Method method : methods)
		        {
		            System.out.println("method:" + method.getName());

		            Type returnType = method.getGenericReturnType();
		            System.out.println(returnType+"%%%%%%");
		      }
		        //TODO �����DaoImpl��read()�����ķ���ֵ�����ô˷���ֵ��ΪIDao�ӿ�find()�еĲ�����
		}
		 

}
