package cn.itcast.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


import cn.itcast.domain.Student4jaxp;
import cn.itcast.utils.XmlUtils4jaxp;

public class StudentDao4jaxp {

	/*
	 <student idcard="111" examid="222">
		<name>张三</name>
		<location>沈阳</location>
		<grade>89</grade>
	</student>

	 */
	public void add(Student4jaxp student){
		try{
			Document document = XmlUtils4jaxp.getDocument();
			//student_node  //ctrl+1  rename in file
			Element student_node = document.createElement("student");
			student_node.setAttribute("examid", student.getExamid());
			student_node.setAttribute("idcard", student.getIdcard());
			
			Element name = document.createElement("name");
			name.setTextContent(student.getName());
			
			Element location = document.createElement("location");
			location.setTextContent(student.getLocation());
			
			Element grade = document.createElement("grade");
			grade.setTextContent(student.getGrade()+"");
			
			student_node.appendChild(name);
			student_node.appendChild(location);
			student_node.appendChild(grade);
			
			//得到exam结点，并把student挂上去
			document.getElementsByTagName("exam").item(0).appendChild(student_node);
			
			XmlUtils4jaxp.write2Xml(document);
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void delete(String name)
	{
		try
		{
			Document document = XmlUtils4jaxp.getDocument();	
			NodeList list = document.getElementsByTagName("name");
			for(int i=0; i < list.getLength(); i++)
			{
				Node node = list.item(i);
				if(node.getTextContent().equals(name))
				{
					node.getParentNode().getParentNode().removeChild(node.getParentNode());
				}
			}
			XmlUtils4jaxp.write2Xml(document);
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
	}
	
/*	public void delete(String name) throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		Document document  = XmlUtils.getDocument();
		
		Node node = document.getElementsByTagName("name").item(0);
		node.getParentNode().removeChild(node);
		
		XmlUtils.write2Xml(document);
		
	}*/
	
	public  Student4jaxp find(String examid)
	{
		try
		{
			Document document = XmlUtils4jaxp.getDocument();
			NodeList list = document.getElementsByTagName("student");
			for(int i=0; i < list.getLength(); i++)
			{
				Element element = (Element) list.item(i);
				String value = element.getAttribute("examid");
				if(examid.equals(value))
				{
					Student4jaxp student = new Student4jaxp();
					student.setExamid(examid);
					student.setIdcard(element.getAttribute("idcard"));
					student.setName(element.getElementsByTagName("name").item(0).getTextContent());
					student.setLocation(element.getElementsByTagName("location").item(0).getTextContent());
					student.setGrade(Double.parseDouble(element.getElementsByTagName("grade").item(0).getTextContent()));
					
					return student;
				}
			}
		}catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		
		
		return null;
	}
	
	/*public Student find(String examid) throws ParserConfigurationException, SAXException, IOException
	{
		Document document = XmlUtils.getDocument();
		
		NodeList list = document.getElementsByTagName("idcard");
		String content = null;
		for(int i=0; i < list.getLength(); i++)
		{
			content = list.item(i).getTextContent();
			System.out.println(content+=(content+"/"));		
		}
		//TODO 返回值
		return null ;
	}*/
	
}
