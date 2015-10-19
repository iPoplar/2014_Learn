package cn.bmy.daoImpl;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import cn.bmy.utils.XmlUtils2l;

public class DaoImpl2 
{
	@Test
	public void read() throws DocumentException
	{
		Document document = XmlUtils2l.getDocument();
		Element root = document.getRootElement();
		List list = root.elements();
		for(Object el : list)
		{
			System.out.println(el+"$$$$$");
		}
	}
	
}
