package cn.bmy.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;


//控制标签体是否执行
public class SimpleTagDemo1 extends SimpleTagSupport 
{
	//简单标签使用这个方法完成所有业务逻辑
	public void doTag() throws JspException, IOException 
	{
		//得到代表标签体的JspFragment
		JspFragment  jf = this.getJspBody();
		//jsp页面传递过来的都是pageContext
		PageContext pageContext  =	(PageContext) this.getJspContext();
		jf.invoke(pageContext.getOut());
		jf.invoke(null);//默认写给浏览器；
		super.doTag();
	}
	
	

}
