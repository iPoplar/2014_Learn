package cn.bmy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	/*filter的三种典型应用:
	 * 1.可以在filter中根据条件决定是否调用chain.doFilter(request,response)方法,是否让目标资源执行
	 * 2.在让目标资源执行之前，可以对request/response做预处理，再让目标资源执行
	 * 3.在目标资源执行之后，可以捕获目标资源的执行结果，从而实现一些特殊的功能
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		//对request和response进行一些预处理
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("filterdemo1执行之前！！");
		chain.doFilter(request, response);//让目标资源执行，放行
		System.out.println("filterdemo1执行之后！！");
	

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
	public void destroy() {
		// TODO Auto-generated method stub

	}


}
