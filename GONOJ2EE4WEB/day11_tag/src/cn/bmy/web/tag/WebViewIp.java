package cn.bmy.web.tag;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

/**
 * ��web������ʼִ�б�ǩʱ����������·�����ɱ�ǩ�ĳ�ʼ��
	WEB�������ñ�ǩ�����������setJspContext������������JSPҳ���pageContext���󴫵ݸ���ǩ����������
	WEB�������ñ�ǩ�����������setParent������������ǩ���������󴫵ݸ������ǩ����������
	ע�⣬ֻ���ڱ�ǩ���ڸ���ǩ������£�WEB�����Ż�������������
	������ñ�ǩʱ���������ԣ�����������ÿ�����Զ�Ӧ��setter����������ֵ���ݸ���ǩ����������
	�����ǩ������ֵ��EL���ʽ��ű����ʽ����WEB�������ȼ�����ʽ��ֵ��Ȼ���ֵ���ݸ���ǩ����������
	����򵥱�ǩ�б�ǩ�壬����������setJspBody�����Ѵ����ǩ���JspFragment���󴫵ݽ�����
 */
/**
 * ʵ��Tag�ӿڵ�Java��(��ǩ��������)��
 */
public class WebViewIp implements Tag 
{
	private PageContext pageContext;
	
	public int doStartTag() throws JspException
	{
		
		HttpServletRequest request = (HttpServletRequest) pageContext.getRequest();
		JspWriter out = pageContext.getOut();
		
		String ip = request.getRemoteAddr();//��ȡ�ͻ���ip
		try //��Ϊ���಻���׳��ȸ��������쳣��so������ֻ�ܰ�Χ��
		{
			out.write(ip);	//����ͻ���
		} catch (IOException e) 
		{
			throw new RuntimeException(e);//���ܴ�ӡ���ͻ���ѽ��so���׳�����ʱ�쳣��
		}
		
		return 0;
	}

	public int doEndTag() throws JspException {
		return 0;
	}

	
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	public void release() {
		// TODO Auto-generated method stub

	}

	public void setPageContext(PageContext pc) 
	{
		this.pageContext = pc;
	}

	public void setParent(Tag t) {
		// TODO Auto-generated method stub

	}

}
