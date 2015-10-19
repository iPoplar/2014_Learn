package cn.bmy.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//控制标签体是否执行 <控制返回值>
public class TagDemo1 extends TagSupport
{

	public int doAfterBody() throws JspException
	{
		return Tag.SKIP_BODY;
	}
	

}
