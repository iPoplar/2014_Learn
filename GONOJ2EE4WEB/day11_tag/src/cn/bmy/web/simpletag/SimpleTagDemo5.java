package cn.bmy.web.simpletag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//ͨ�����Կ��Ʊ�ǩ���ִ�д���
public class SimpleTagDemo5 extends SimpleTagSupport 
{
	private int count;
	
	public void setCount(int count)
	{
		this.count = count;
	}
	
	public void doTag() throws JspException, IOException 
	{
		for(int i=0; i < count; i++)
		{
			this.getJspBody().invoke(null);
		}
	}
	

}
