package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * 当web容器开始执行标签时，会调用如下方法完成标签的初始化
	WEB容器调用标签处理器对象的setJspContext方法，将代表JSP页面的pageContext对象传递给标签处理器对象。
	WEB容器调用标签处理器对象的setParent方法，将父标签处理器对象传递给这个标签处理器对象。
	注意，只有在标签存在父标签的情况下，WEB容器才会调用这个方法。
	如果调用标签时设置了属性，容器将调用每个属性对应的setter方法把属性值传递给标签处理器对象。
	如果标签的属性值是EL表达式或脚本表达式，则WEB容器首先计算表达式的值，然后把值传递给标签处理器对象。
	如果简单标签有标签体，容器将调用setJspBody方法把代表标签体的JspFragment对象传递进来。
 */
/**
 * 实现Tag接口的Java类(标签处理器类)。
 */
public class WebViewIp implements Tag 
{
	private PageContext pageContext;
	
	public int doStartTag() throws JspException
	{
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		
		String ip = request.getRemoteAddr();//获取客户机ip
		try //因为子类不能抛出比父类更多的异常，so，这里只能包围；
		{
			out.write(ip);	//打给客户机
		} catch (IOException e) 
		{
			throw new RuntimeException(e);//不能打印给客户机呀，so，抛出运行时异常；
		}
		
		return 0;
	}

	public int doEndTag() throws JspException {
		return 0;
	}

	
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release() {
		// TODO Auto-generated method stub

	}

	public void setPageContext(PageContext pc) 
	{
		this.pageContext = pc;
	}

	public void setParent(Tag t) {
		// TODO Auto-generated method stub

	}

}
