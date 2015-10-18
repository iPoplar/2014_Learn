package cn.bmy.interceptor;

import cn.bmy.controller.commen.IInterceptor;
import cn.bmy.controller.commen.InterceptorChain;

public class OtherInter implements IInterceptor {


	public String exec(InterceptorChain chain) {
		String str;
		System.out.println("OtherInter Begin---");
		System.out.println("调用下一个环节之前");
		str = chain.doNext();
		System.out.println("调用下一个环节之后");
		System.out.println("OtherInter End---");
		return str;
	}

}
