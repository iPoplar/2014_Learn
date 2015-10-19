package cn.bmy.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class FilterDemo1 implements Filter {

	/*filter�����ֵ���Ӧ��:
	 * 1.������filter�и������������Ƿ����chain.doFilter(request,response)����,�Ƿ���Ŀ����Դִ��
	 * 2.����Ŀ����Դִ��֮ǰ�����Զ�request/response��Ԥ��������Ŀ����Դִ��
	 * 3.��Ŀ����Դִ��֮�󣬿��Բ���Ŀ����Դ��ִ�н�����Ӷ�ʵ��һЩ����Ĺ���
	 */
	
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException 
	{
		//��request��response����һЩԤ����
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		System.out.println("filterdemo1ִ��֮ǰ����");
		chain.doFilter(request, response);//��Ŀ����Դִ�У�����
		System.out.println("filterdemo1ִ��֮�󣡣�");
	

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}
	public void destroy() {
		// TODO Auto-generated method stub

	}


}
