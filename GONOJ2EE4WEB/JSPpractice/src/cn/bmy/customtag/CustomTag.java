package cn.bmy.customtag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 开发自定义标签需要的步骤：
 * 1.开发标签处理器类;
 * 2.开发标签描述文件;
 * 3.使用标签;
 * 
 */
public class CustomTag extends TagSupport
{
	private String name = null;
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int doStartTag()
	{
		JspWriter out = pageContext.getOut();
		try {
			out.print(name);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return EVAL_BODY_AGAIN;
		
	}

}
