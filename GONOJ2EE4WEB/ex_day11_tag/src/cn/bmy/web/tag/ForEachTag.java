package cn.bmy.web.tag;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag extends SimpleTagSupport
{
	private List items;
	private String var;
	
	public void setItems(List items)
	{
		this.items = items;
	}
	
	public void setVar(String var)
	{
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException 
	{
		PageContext context = (PageContext) this.getJspContext();
		Iterator it = items.iterator();
		while(it.hasNext())
		{
			Object obj = it.next();
			context.setAttribute(var, obj);
			this.getJspBody().invoke(null);//通知标签体执行
		}
	}

}
