package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//c:if 标签处理器类  
public class IfTag extends SimpleTagSupport 
{
	private boolean test;
	
	public void setTest(boolean test)
	{
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException 
	{
		if(test)
		{
			this.getJspBody().invoke(null);
		}
		
	}
	
	

}
