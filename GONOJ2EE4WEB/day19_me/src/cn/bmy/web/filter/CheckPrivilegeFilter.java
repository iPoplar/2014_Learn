package cn.bmy.web.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.bmy.domain.Privilege;
import cn.bmy.domain.User;
import cn.bmy.service.SecurityService;

public class CheckPrivilegeFilter implements Filter 
{
	private Map<String,Privilege>map = new HashMap();

	public void init(FilterConfig filterConfig) throws ServletException {

		map.put("/day19/manager/AddProduct", new Privilege("添加商品"));
		map.put("/day19/manager/UpdateProduct", new Privilege("修改商品"));
		map.put("/day19/manager/DeleteProduct",new Privilege("删除商品"));
		map.put("/day19/manager/ShowOrder",new Privilege("查看订单"));
		
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//1.得到用户请求的uri
		String uri = request.getRequestURI();
		
		//2.得到访问资源需要的权限
		Privilege p = map.get(uri);
		
		//3.判断得到的权限是否为空，为空则代表访问改资源不需要权限，则直接放行
		if(p==null)
		{
			chain.doFilter(request, response);
			return;
		}
		
		//4.如果需要权限，则检查用户是否已登录，如果没有登录，先让用户登录
		User user = (User) request.getSession().getAttribute("user");
		if(user==null)
		{
			request.setAttribute("message", "对不起，请登录后再来!!!");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//5.如果用户已经登录，得到用户拥有的所有权限
		SecurityService service = new SecurityService();
		Set set = service.getUserAllPrivilege(user.getId());
		
		//6.判断用户拥有的权限中，是否含有访问资源需要权限
		if(!set.contains(p)){  //list[p1,p2]  p1.equals(p)  object false
			request.setAttribute("message", "对不起，您没有权限访问，请联系管理员！！");
			request.getRequestDispatcher("/message.jsp").forward(request, response);
			return;
		}
		
		//7.有权限，放行
		chain.doFilter(request, response);
	}

	
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
