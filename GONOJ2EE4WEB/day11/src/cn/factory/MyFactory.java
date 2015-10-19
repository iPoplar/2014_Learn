package cn.factory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class MyFactory 
{
	private static Document document = null;
	private static Map<String, XMLBean> map = null;
	
	static
	{
		//����xml�ĵ�
		SAXReader reader = new SAXReader();
		try {
			document = reader.read("F:\\GONOJ2EE4WEB\\day11\\src\\Factory.xml");
			Element element = document.getRootElement();
			
			List<Element> list = element.elements();
			for(Element e : list)
			{
				if(map == null)
					map = new HashMap<String, XMLBean>();
				XMLBean bean = new XMLBean();
				bean.setId(e.attributeValue("id"));
				bean.setClazz(e.attributeValue("class"));
				
				map.put(e.attributeValue("id"), bean);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	
	public static Object getBean(String id)
	{
		XMLBean bean = map.get(id);
		//�μ��ĵ�Class.forname������������϶ȵ�һ�ַ�ʽ
		String clazz = bean.getClazz();
		Object object = null;
		try {
			object = Class.forName(clazz).newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return object;
	}
}
