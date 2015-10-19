package com.mec.common;


public interface IInterceptor {
	public String exec(InterceptorChain chain);
}
