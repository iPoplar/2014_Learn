package com.mec.interceptor;

import com.mec.common.IInterceptor;
import com.mec.common.InterceptorChain;

public class WriteLogInter implements IInterceptor{

	@Override
	public String exec(InterceptorChain chain) {
		String str;
		System.out.println("WriteLogInter Begin---");
		System.out.println("������һ������֮ǰ");
		str = chain.doNext();
		System.out.println("������һ������֮��");
		System.out.println("WriteLogInter End---");
		return str;
	}
}
