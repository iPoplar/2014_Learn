package cn.bmy.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;


//���Ʊ�ǩ���Ƿ�ִ��
public class SimpleTagDemo1 extends SimpleTagSupport 
{
	//�򵥱�ǩʹ����������������ҵ���߼�
	public void doTag() throws JspException, IOException 
	{
		//�õ������ǩ���JspFragment
		JspFragment  jf = this.getJspBody();
		//jspҳ�洫�ݹ����Ķ���pageContext
		PageContext pageContext  =	(PageContext) this.getJspContext();
		jf.invoke(pageContext.getOut());
		jf.invoke(null);//Ĭ��д���������
		super.doTag();
	}
	
	

}
