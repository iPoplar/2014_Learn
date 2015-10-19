package cn.bmy.web.simpletag;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

// Ù–‘Àµ√˜
public class SimpleTagDemo6 extends SimpleTagSupport 
{
	private Date date;
	
	public void setDate(Date date)
	{
		this.date = date;
	}

	public void doTag() throws JspException, IOException 
	{
		System.out.println(date);
	}
	
	

}
