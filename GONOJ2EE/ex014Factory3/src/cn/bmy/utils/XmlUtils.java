package cn.bmy.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class XmlUtils 
{
	public static org.dom4j.Document getDocument() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		
		org.dom4j.Document document = reader.read(new File("src/student.xml"));
		
		return document;			
	}
	
	public static void write2Xml(org.dom4j.Document document) throws IOException
	{		
		OutputFormat format = OutputFormat.createCompactFormat();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/student.xml"),format);
		writer.write(document);
		writer.close();
	}

}
