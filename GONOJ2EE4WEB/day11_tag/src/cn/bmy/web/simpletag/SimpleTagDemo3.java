package cn.bmy.web.simpletag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo3 extends SimpleTagSupport 
{
	//ÐÞ¸Ä±êÇ©Ìå
	public void doTag() throws JspException, IOException {
		JspFragment jf = this.getJspBody();
		StringWriter sw = new StringWriter();
		jf.invoke(sw);
		
		String content = sw.getBuffer().toString();
		PageContext pageContent = (PageContext) this.getJspContext();
		pageContent.getOut().write(content);
	}
	
	

}
