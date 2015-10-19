package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.Tag;

public class TagDemo4 extends BodyTagSupport
{
	//修改标签体
	public int doStartTag() throws JspException 
	{
		return BodyTag.EVAL_BODY_BUFFERED;
	}

	
	public int doEndTag() throws JspException 
	{
		//拿到标签体
		String content = this.getBodyContent().getString();
		String retult = content.toUpperCase();
		try {
			this.pageContext.getOut().write(retult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return Tag.EVAL_PAGE;
	}

	
}
