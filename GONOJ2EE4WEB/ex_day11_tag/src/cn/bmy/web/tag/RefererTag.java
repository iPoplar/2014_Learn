package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//�������ı�ǩ��������
public class RefererTag extends SimpleTagSupport 
{
	private String site;
	private String page;
	
	public void setSite(String site)
	{
		this.site = site;
	}
	
	public void setPage(String page)
	{
		this.page = page;
	}

	public void doTag() throws JspException, IOException 
	{
		//���������Ǵ��ĸ�ҳ������
		PageContext pageContext = (PageContext) this.getJspContext();
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		//referer�����ͨ�����ͷ���߷��������Ǵ���������
		String referer = request.getHeader("referer");
		
		//�ж�
		if(referer == null || !referer.startsWith(site))
		{
			HttpServletResponse response = (HttpServletResponse) pageContext.getResponse();
			String webroot = request.getContextPath();//ex_day11_tag
			if(page.startsWith(webroot))
			{
				response.sendRedirect(page);
			}
			else
			{
				response.sendRedirect(webroot+page);
			}
			//�ض���󣬿��Ʊ�����ҳ�治Ҫִ��
			throw new SkipPageException();
		}
		
	}

}
