package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class WhenTag extends SimpleTagSupport
{
	private boolean test;
	
	public void setTest(boolean test)
	{
		this.test = test;
	}

	public void doTag() throws JspException, IOException {
		ChooseTag parent = (ChooseTag) this.getParent();
		if(test==true && parent.isOk()==false)
		{
			this.getJspBody().invoke(null);
			parent.setOk(true);
		}
	}
	
	

}
