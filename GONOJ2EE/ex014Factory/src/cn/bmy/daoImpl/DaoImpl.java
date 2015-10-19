package cn.bmy.daoImpl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import cn.bmy.dao.IDao;
import cn.bmy.utils.XmlUtils;

public class DaoImpl// implements IDao 
{
	public static void main(String a[])
	{
//		try {
//			read();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();

		System.out.println(DaoImpl.class.getResource("/").getPath().toString().substring(1));
	}
	
	@Test
	public static void read() throws DocumentException
	{
		Document document = XmlUtils.getDocument();
		Element root = document.getRootElement();
		System.out.println(root.getName()+"***********");
		String collect = root.getName()+"";
		
		List<Element> l = root.elements();
		System.out.println(l.size());
		System.out.println(l.get(0).getName());
		System.out.println(l.get(0).attributeValue("examid"));
		List<Element> l2 = l.get(0).elements();
		System.out.println(l2.get(0).getText());
//		l = root.elements();		
//		//TODO 找出所有标签，放到集合中，返回
//		for(String i : l)
//		{
//			System.out.println(i+"@@@@@@@@@");			
//		} 
//		return null;
	}
	
	/* (non-Javadoc)
	 * @see cn.bmy.daoImpl.IDao#find()
	 */
	@Test
	public void find(String element) throws DocumentException
	{
		Document document = XmlUtils.getDocument();
		Element root = document.getRootElement();
		Element name = root.element(element);
		System.out.println(name);
	}
	
//	@Test
//	public void findWithXpath()// throws DocumentException
//	{
//		Document document = XmlUtils.getDocument();
//		Element e = (Element) document.selectNodes("//student").get(0);
//		System.out.println(e.getText());		
//	}
	
}
