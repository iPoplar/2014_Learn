package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class RefererTag extends SimpleTagSupport 
{
	private String site;
	private String page;
	
	//设置属性，set就okl
	public void setSite(String site) {
		this.site = site;
	}
	public void setPage(String page) {
		this.page = page;
	}
	
	public void doTag() throws JspException, IOException 
	{
		//看来访者是从哪个页面来的
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		String referer = request.getHeader("referer");
		//http://www.sina.com/index.html
		
		//判断
		if(referer == null || !referer.startsWith(site))
		{
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			String webroot = request.getContextPath();//day11_example
			if(page.startsWith(webroot))
			{
				response.sendRedirect(page);
			}
			else
			{
				response.sendRedirect(webroot + page);
			}
			//重定向后，控制保护的页面不要执行
			throw new SkipPageException();
		}
			
		
		
			
	}
	

}
