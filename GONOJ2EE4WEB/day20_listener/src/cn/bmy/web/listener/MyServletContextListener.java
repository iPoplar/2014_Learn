package cn.bmy.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextÏú»Ù");

	}

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("context´´½¨");

	}

}
