package cn.bmy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo3 implements Filter {

	//Ϊ�˻�ȡ���õĳ�ʼ������
	private FilterConfig config = null;
	
	public void destroy() {
		System.out.println("filter������");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		//��ȡ���õĳ�ʼ������
		System.out.println(this.config.getInitParameter("xiaobai"));
	}

	public void init(FilterConfig filterConfig) throws ServletException {

		System.out.println("filter������");
		this.config = filterConfig;
	}

}
