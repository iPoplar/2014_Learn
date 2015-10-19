package cn.bmy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo3 implements Filter {

	//为了获取配置的初始化参数
	private FilterConfig config = null;
	
	public void destroy() {
		System.out.println("filter销毁了");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//获取配置的初始化参数
		System.out.println(this.config.getInitParameter("xiaobai"));
	}

	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("filter创建了");
		this.config = filterConfig;
	}

}
