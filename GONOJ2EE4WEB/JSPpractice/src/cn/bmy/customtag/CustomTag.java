package cn.bmy.customtag;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * �����Զ����ǩ��Ҫ�Ĳ��裺
 * 1.������ǩ��������;
 * 2.������ǩ�����ļ�;
 * 3.ʹ�ñ�ǩ;
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
