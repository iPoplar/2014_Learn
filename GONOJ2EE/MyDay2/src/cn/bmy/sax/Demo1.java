package cn.bmy.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

public class Demo1 
{
	/**
	 * sax方式解析book1.xml
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * 
	 */
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		//1.创建工厂
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.用工厂创建解析器
		SAXParser sp = factory.newSAXParser();
		
		//3.利用解析器得到reader
		XMLReader reader = sp.getXMLReader();
		
		//4.在解析xml文档之前，设置好事件处理器
		reader.setContentHandler(new MyContentHandler2());
		//4.利用reader读取xml文档
		reader.parse("src/book1.xml");
	}
}

//用于获取第一个售价节点的值：<售价>19</售价>
class MyContentHandler2 extends DefaultHandler
{
	private boolean isOk = false;
	private int index = 1;
	@Override
	public void characters(char[] ch, int start, int length)throws SAXException 
	{
		if(isOk == true && index == 1)
		{
			System.out.println(new String(ch,start,length));
		}
		//super.characters(ch, start, length);
	}
	@Override
	public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException	
	{
		if(qName.equals("售价"))
		{
			isOk = true;
		}
		//super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException 
	{
		if(qName.equals("售价"))
		{
			isOk = false;
			index++;
		}
		//super.endElement(uri, localName, qName);
	}
}

//得到xml文档内容的事件处理器
class MyContentHandler implements ContentHandler
{

	@Override
	public void startElement(String uri, String localName, String qName,Attributes atts) throws SAXException 
	{		
		System.out.println("当前解析到了：" + qName + ",这是个开始标签");
		for(int i=0; i<atts.getLength(); i++)
		{
			String attname = atts.getQName(i);
			String attvalue = atts.getValue(i);
			System.out.println(attname + "=" + attvalue);
		}

	}

	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException 
	{
		System.out.println("当前解析到了：" + qName + ",这是个结束标签");
		
		
	}

	@Override
	public void characters(char[] ch, int start, int length)throws SAXException 
	{
		System.out.println("当前解析到了内容：" + new String(ch,start,length));
		
	}
	
	@Override
	public void setDocumentLocator(Locator locator) {
		
	}

	@Override
	public void startDocument() throws SAXException {
		
	}

	@Override
	public void endDocument() throws SAXException {
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		
	}
	
	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		
	}
	
}
