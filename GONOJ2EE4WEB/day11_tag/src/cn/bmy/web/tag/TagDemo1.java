package cn.bmy.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//���Ʊ�ǩ���Ƿ�ִ�� <���Ʒ���ֵ>
public class TagDemo1 extends TagSupport
{

	public int doAfterBody() throws JspException
	{
		return Tag.SKIP_BODY;
	}
	

}
