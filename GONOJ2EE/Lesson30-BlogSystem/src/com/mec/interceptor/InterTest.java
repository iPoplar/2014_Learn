package com.mec.interceptor;

import java.util.ArrayList;

import com.mec.common.IInterceptor;
import com.mec.common.InterceptorChain;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class InterTest {

	public static void main(String[] args) {
		ArrayList<IInterceptor> allInters = new ArrayList<IInterceptor>();
		
		allInters.add(new OtherInter());
		allInters.add(new LoginCheckInter());
		allInters.add(new WriteLogInter());
		
		InterceptorChain  interChain = new InterceptorChain(allInters, new Object());
		interChain.doNext();
	}
}
