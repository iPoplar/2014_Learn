package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class OtherwiseTag extends SimpleTagSupport
{

	public void doTag() throws JspException, IOException 
	{
		ChooseTag parent = (ChooseTag) this.getParent();
		if(parent.isOk()==false)
		{
			this.getJspBody().invoke(null);
			parent.setOk(true);
		}
		
	}
	

}
