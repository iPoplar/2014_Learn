package cn.bmy.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyBean implements HttpSessionActivationListener {
	/**
	 * 对session自己的监听
	 * 可用于统计 网页的访问数据量
	 */
	//也称之为活化
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("session从硬盘回到内存了");

	}

	//也称之为钝化
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("session被序列化到硬盘了");

	}

}
