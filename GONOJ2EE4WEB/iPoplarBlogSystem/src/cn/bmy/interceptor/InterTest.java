package cn.bmy.interceptor;

import java.util.ArrayList;

import cn.bmy.controller.commen.IInterceptor;
import cn.bmy.controller.commen.InterceptorChain;

public class InterTest {

	public static void main(String[] args) {
		ArrayList<IInterceptor> allInters = new ArrayList<IInterceptor>();
		
		allInters.add(new OtherInter());
		allInters.add(new LoginCheckInter());
		allInters.add(new WriteLogInter());
		
		InterceptorChain interChain = new InterceptorChain(allInters, new Object());
		interChain.doNext();
	}

}
