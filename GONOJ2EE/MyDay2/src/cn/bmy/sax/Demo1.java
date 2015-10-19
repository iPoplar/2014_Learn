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
	 * sax��ʽ����book1.xml
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * 
	 */
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		//1.��������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.�ù�������������
		SAXParser sp = factory.newSAXParser();
		
		//3.���ý������õ�reader
		XMLReader reader = sp.getXMLReader();
		
		//4.�ڽ���xml�ĵ�֮ǰ�����ú��¼�������
		reader.setContentHandler(new MyContentHandler2());
		//4.����reader��ȡxml�ĵ�
		reader.parse("src/book1.xml");
	}
}

//���ڻ�ȡ��һ���ۼ۽ڵ��ֵ��<�ۼ�>19</�ۼ�>
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
		if(qName.equals("�ۼ�"))
		{
			isOk = true;
		}
		//super.startElement(uri, localName, qName, attributes);
	}
	@Override
	public void endElement(String uri, String localName, String qName)throws SAXException 
	{
		if(qName.equals("�ۼ�"))
		{
			isOk = false;
			index++;
		}
		//super.endElement(uri, localName, qName);
	}
}

//�õ�xml�ĵ����ݵ��¼�������
class MyContentHandler implements ContentHandler
{

	@Override
	public void startElement(String uri, String localName, String qName,Attributes atts) throws SAXException 
	{		
		System.out.println("��ǰ�������ˣ�" + qName + ",���Ǹ���ʼ��ǩ");
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
		System.out.println("��ǰ�������ˣ�" + qName + ",���Ǹ�������ǩ");
		
		
	}

	@Override
	public void characters(char[] ch, int start, int length)throws SAXException 
	{
		System.out.println("��ǰ�����������ݣ�" + new String(ch,start,length));
		
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
