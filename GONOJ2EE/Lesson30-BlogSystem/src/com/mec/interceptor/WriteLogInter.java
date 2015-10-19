package com.mec.interceptor;

import com.mec.common.IInterceptor;
import com.mec.common.InterceptorChain;

public class WriteLogInter implements IInterceptor{

	@Override
	public String exec(InterceptorChain chain) {
		String str;
		System.out.println("WriteLogInter Begin---");
		System.out.println("调用下一个环节之前");
		str = chain.doNext();
		System.out.println("调用下一个环节之后");
		System.out.println("WriteLogInter End---");
		return str;
	}
}
