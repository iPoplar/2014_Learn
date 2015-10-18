package cn.bmy.controller.commen;

import java.util.HashMap;

public interface ISessionAware 
{
	public HashMap<String, Object> getSession();
	public void setSession(HashMap<String, Object> session);
}
