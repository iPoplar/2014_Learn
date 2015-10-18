package cn.bmy.controller.commen;

import java.util.ArrayList;

public class InterceptorChain 
{
	private ArrayList<IInterceptor> interceptorStack;
	private int currentIndex;
	private String retStr;
	private Object action;
	
	public Object getAction()
	{
		return action;
	}
	
	public String doNext()
	{
		if(this.currentIndex >= this.interceptorStack.size())
		{
			return retStr;
		}
		IInterceptor currentInter = this.interceptorStack.get(this.currentIndex);
		this.currentIndex++;
		retStr = currentInter.exec(this);
		return retStr;
	
	}
	
	public InterceptorChain(ArrayList<IInterceptor> interceptorStack, Object action)
	{
		this.currentIndex = 0;
		this.interceptorStack = interceptorStack;
		this.action = action;
	}

}
