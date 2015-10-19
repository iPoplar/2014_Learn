package cn.itcast.dao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;
import org.w3c.dom.NodeList;

import cn.itcast.domain.Student4dom4j;
import cn.itcast.domain.Student4jaxp;
import cn.itcast.utils.XmlUtils4dom4j;
import cn.itcast.utils.XmlUtils4jaxp;

public class StudentDao4dom4j 
{
	@Test
	public void add(Student4dom4j student)
	{
		try
		{
			Document document = XmlUtils4dom4j.getDocument();
			Element student_node = DocumentHelper.createElement("student");
			student_node.addAttribute("examid",student.getExamid() );
			student_node.addAttribute("idcard", student.getIdcard());
			//向指定结点上挂子节点的便捷方式
			student_node.addElement("name").setText(student.getName());
			student_node.addElement("location").setText(student.getLocation());
			student_node.addElement("grade").setText(student.getGrade()+"");
			
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	public void delete(String name)
	{
		try
		{
			Document document = XmlUtils4dom4j.getDocument();
			List list = document.selectNodes("//name");
			
			Iterator it = list.iterator();
			while(it.hasNext())
			{
				Element name_node = (Element)it.next();
				if(name_node.getText().equals(name))
				{
					name_node.getParent().getParent().remove(name_node.getParent());
					XmlUtils4dom4j.write2Xml(document);
					return;
				}
			}
			throw new RuntimeException("Sorry,can't find student that want delete!!!");
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
	}
	
	
	public Student4dom4j find (String examid)
	{
		try
		{
			Document document = XmlUtils4dom4j.getDocument();
			Element node = (Element) document.selectSingleNode("//student[@examid='"+examid+"']");
			if(node != null)
			{
				Student4dom4j s = new Student4dom4j();
				s.setExamid(node.attributeValue("examid"));
				s.setIdcard(node.attributeValue("idcard"));
				s.setName(node.element("name").getText());
				s.setLocation(node.element("location").getText());
				s.setGrade(Double.parseDouble(node.element("grade").getText()));
				return s;
			}
			
			return null;
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}
}

