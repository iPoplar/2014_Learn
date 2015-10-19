package com.mec.blogSystem.action.blog;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.mec.blogSystem.action.BaseAction;
import com.opensymphony.xwork2.Action;

public class AddBlogAction extends BaseAction{
	private String blogTit;
	private String blogContent;
	private Map<String, Object> session;

	public void setBlogTit(String blogTit) {
		this.blogTit = blogTit;
	}

	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session = arg0;
	}

	@Override
	public String execute() throws Exception {
		return "SUCCESS";
	}
	
	public AddBlogAction(){
		super();
	}
}
