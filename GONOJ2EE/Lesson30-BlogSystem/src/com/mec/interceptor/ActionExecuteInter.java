package com.mec.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.mec.common.IInterceptor;
import com.mec.common.InterceptorChain;

public class ActionExecuteInter implements IInterceptor{

	@Override
	public String exec(InterceptorChain chain) {
		Object action = chain.getAction();
		Method executeMetho;
		String retString = null;
		
		try {
			executeMetho = action.getClass().getMethod("execute");
			retString = (String)executeMetho.invoke(action);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return retString;
	}

}
