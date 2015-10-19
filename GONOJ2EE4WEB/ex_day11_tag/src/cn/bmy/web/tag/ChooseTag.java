package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/*if-else 标签的类的加载器，此标签要实现类之间的数据共享，所以用生成了一个

父标签，子标签通过getParent()方法获取父标签中的数据
参与此标签的类有ChooseTag 、OtherwiseTag 、WhenTag
*/ 
public class ChooseTag extends SimpleTagSupport 
{
	private boolean isOk;
	
	public boolean isOk()
	{
		return isOk;
	}
	
	public void setOk(boolean isOk)
	{
		this.isOk = isOk;
	}
	
	@Override
	public void doTag() throws JspException, IOException 
	{
		this.getJspBody().invoke(null);
	}
	
}