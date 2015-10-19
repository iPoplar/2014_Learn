package cn.itcast.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.domain.Privilege;
import cn.itcast.domain.User;
import cn.itcast.service.SecurityService;

public class CheckPrivilegeFilter implements javax.servlet.Filter {

	private Map<String,Privilege> map = new HashMap();
	
	public void init(FilterConfig filterConfig) throws ServletException {

		map.put("/day19/manager/AddProduct",new Privilege("�����Ʒ"));
		map.put("/day19/manager/UpdateProduct",new Privilege("�޸���Ʒ"));
		map.put("/day19/manager/DeleteProduct",new Privilege("ɾ����Ʒ"));
		map.put("/day19/manager/ShowOrder",new Privilege("�鿴����"));
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//1.�õ��û������URI
		String uri = request.getRequestURI();
		
		//2.�õ�������Դ��Ҫ��Ȩ��
		Privilege p = map.get(uri);
		
		//3.�жϵõ���Ȩ���Ƿ�Ϊ�գ�Ϊ���������ʸ���Դ����ҪȨ�ޣ���ֱ�ӷ���
		if(p==null){
			chain.doFilter(request, response);
			return;
		}
		
		//4.�����ҪȨ�ޣ������û��Ƿ��ѵ�½�����û�е�½�������û���½
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "�Բ������½����������");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//5.����û��Ѿ���½,�õ��û�ӵ�е�����Ȩ��
		SecurityService service = new SecurityService();
		Set set = service.getUserAllPrivilege(user.getId());
		
		//6.�ж��û�ӵ�е�Ȩ���У��Ƿ��з�����Դ��ҪȨ��
		if(!set.contains(p)){  //list[p1,p2]  p1.equals(p)  object false
			request.setAttribute("message", "�Բ�����û��Ȩ�޷��ʣ�����ϵ����Ա����");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//7.��Ȩ�ޣ�����
		chain.doFilter(request, response);
		
	}

	
	public void destroy() {}

	
	

}
