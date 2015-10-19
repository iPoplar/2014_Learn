package cn.bmy.framework;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyFrameWork
{
	public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException 
	{
		BufferedReader br = new BufferedReader(new FileReader("src/config.txt"));
		String className = br.readLine();
		String methodName = br.readLine();
		
		Class clazz = Class.forName(className);
		Method method = clazz.getMethod(methodName, null);
		method.invoke(clazz.newInstance(), null);
		
		
	}

}
