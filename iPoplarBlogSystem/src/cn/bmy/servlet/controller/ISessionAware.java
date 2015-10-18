package cn.bmy.servlet.controller;

import java.util.HashMap;

public interface ISessionAware
{
	public HashMap<String, Object> getSession();
	public void setSession(HashMap<String, Object> session);

}
