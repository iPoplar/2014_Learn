package cn.bmy.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;

//����jspҳ���Ƿ�ִ��
public class TagDemo2 extends TagSupport 
{

	public int doAfterBody() throws JspException
	{
		//return Tag.SKIP_PAGE;//����jsp����ִ��
		return Tag.EVAL_PAGE;
	}
	 

}
