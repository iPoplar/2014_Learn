package cn.bmy.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//���Ʊ�ǩ���µ�jsp��ִ��
public class SimpleTagDemo4 extends SimpleTagSupport 
{

	public void doTag() throws JspException, IOException {
		throw new SkipPageException();
	}
	

}
