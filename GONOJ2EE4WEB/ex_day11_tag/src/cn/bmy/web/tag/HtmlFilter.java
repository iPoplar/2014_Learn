package cn.bmy.web.tag;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
//ת���ǩ
public class HtmlFilter extends SimpleTagSupport 
{
	@Override
	public void doTag() throws JspException, IOException 
	{
		StringWriter sw = new StringWriter();
		this.getJspBody().invoke(sw);
		
		//�õ���ǩ��:<a href="">���</a>
		String content = sw.getBuffer().toString();
		content = filter(content);
		
		//���ת������
		this.getJspContext().getOut().write(content);
	}

	private String filter(String message) 
	{
		if(message==null)
		{
			return(null);
		}
		
		char content[] = new char[message.length()];
		message.getChars(0, message.length(), content, 0);
		StringBuffer result = new StringBuffer(content.length+50);
		 for (int i = 0; i < content.length; i++) {
	            switch (content[i]) {
	            case '<':
	                result.append("&lt;");
	                break;
	            case '>':
	                result.append("&gt;");
	                break;
	            case '&':
	                result.append("&amp;");
	                break;
	            case '"':
	                result.append("&quot;");
	                break;
	            default:
	                result.append(content[i]);
	            }
	        }
	        return (result.toString());
	}

}
