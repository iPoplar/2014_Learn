package com.mec.interceptor;

import com.mec.common.IInterceptor;
import com.mec.common.InterceptorChain;

public class LoginCheckInter implements IInterceptor{

	@Override
	public String exec(InterceptorChain chain) {
		String str;
		System.out.println("LoginCheckInter Begin---");
		System.out.println("调用下一个环节之前");
		str = chain.doNext();
		System.out.println("调用下一个环节之后");
		System.out.println("LoginCheckInter End---");
		return str;
	}
}
