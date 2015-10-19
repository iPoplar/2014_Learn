package cn.bmy.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyBean2 implements HttpSessionBindingListener {

	//这种监听器，是自己监听自己
	//用于场景：eg：某论坛上线者的显示
	private String name;
	
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("自己被加到session中了");

	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("自己被session踢出来了");

	}

}
