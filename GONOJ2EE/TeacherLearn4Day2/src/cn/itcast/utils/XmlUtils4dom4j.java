package cn.itcast.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.w3c.dom.Document;

public class XmlUtils4dom4j 
{
	public static org.dom4j.Document getDocument() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		org.dom4j.Document document = reader.read(new File("src/student.xml"));
		return null;
			
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
