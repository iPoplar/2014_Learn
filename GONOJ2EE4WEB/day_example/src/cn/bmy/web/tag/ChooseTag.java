package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

//∏∏±Í«©
public class ChooseTag extends SimpleTagSupport 
{
	private boolean isOk;
	
	public boolean isOk()
	{
		return isOk;
	}
	
	public void setOk (boolean isOk)
	{
		this.isOk = isOk;
	}

	public void doTag() throws JspException, IOException {
		this.getJspBody().invoke(null);
	}
	
	

}
