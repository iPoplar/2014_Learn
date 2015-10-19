package cn.bmy.interceptor;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import cn.bmy.controller.commen.IInterceptor;
import cn.bmy.controller.commen.InterceptorChain;

public class ActionExecuteInter implements IInterceptor {

	public String exec(InterceptorChain chain)
	{
		Object action = chain.getAction();
		Method executeMetho;
		String retString = null;
		
		try {
			executeMetho = action.getClass().getMethod("execute");
			retString = (String) executeMetho.invoke(action);
			
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		return retString;
	}

}
