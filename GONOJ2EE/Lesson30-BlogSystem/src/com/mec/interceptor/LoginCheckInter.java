package com.mec.interceptor;

import com.mec.common.IInterceptor;
import com.mec.common.InterceptorChain;

public class LoginCheckInter implements IInterceptor{

	@Override
	public String exec(InterceptorChain chain) {
		String str;
		System.out.println("LoginCheckInter Begin---");
		System.out.println("������һ������֮ǰ");
		str = chain.doNext();
		System.out.println("������һ������֮��");
		System.out.println("LoginCheckInter End---");
		return str;
	}
}
