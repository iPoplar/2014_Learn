package cn.bmy.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SimpleTagDemo2 extends SimpleTagSupport
{
	//���Ʊ�ǩִ��10��
	public void doTag() throws JspException, IOException 
	{
		JspFragment jf = this.getJspBody();
		
		for(int i=0; i < 10; i++)
			jf.invoke(null);
	}
	

}
