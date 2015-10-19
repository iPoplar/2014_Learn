package com.mec.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//import org.apache.derby.tools.sysinfo;

/**
 * Servlet Filter implementation class HelloFiter
 */
public class HelloFiter implements Filter {

    /**
     * Default constructor. 
     */
    public HelloFiter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String userName = (String)session.getAttribute("userName");
		Thread th =  Thread.currentThread();
		System.out.println("Filter filter obj is  : " + this.hashCode());
		System.out.println("Filter current thread id is : " + th.getId());
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(userName != null){
			//放行， 校验通过
			chain.doFilter(request, response);
		}else{
			//拦截， 校验不通过
			request.getRequestDispatcher("/msgPage/error/loginError.jsp").forward(request, response);;
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
