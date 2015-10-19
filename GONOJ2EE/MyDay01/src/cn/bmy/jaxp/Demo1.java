package cn.bmy.jaxp;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Demo1
{
	/**
	 * ʹ��jaxp����xml�ĵ�
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		//1.��ȡ����
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				
		//2.����������
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.����xml�ĵ����õ������ĵ�document
		Document document = builder.parse(new File("src/book1.xml"));
		/*//����
		list(document);*/
		read(document);
		
	}
	
	//�õ��ۼ۽���ֵ
	public  static void read(Document doucment) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		NodeList list = document.getElementsByTagName("�ۼ�");
		Node price  = list.item(0);
		
		String value = price.getTextContent();
		System.out.println(value);
				
	}
	@Test
	//�޸Ľ���ֵ���ۼۣ�
	public void update() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		Node price  = document.getElementsByTagName("�ۼ�").item(0);
		price.setTextContent("109");
		
		//���ڴ��е�documentд��xml�ĵ�
		TransformerFactory tf = TransformerFactory.newInstance();
		//�õ�ת����
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
	}
	@Test
	//��ָ���ڵ������Ӻ��ӽڵ㣨�ۼ۽ڵ㣩
	public void add() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		//������Ҫ���ӵĽڵ�
		Node price = document.createElement("�ۼ�");
		price.setTextContent("59Ԫ");
		
		//�õ���Ҫ���ӵĽڵ�ĸ���
		Node parent = document.getElementsByTagName("��").item(0);
		//����Ҫ���ӵĽڵ�ҵ����ڵ���
		parent.appendChild(price);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
	}
	
	//��ָ��λ���ϲ����ۼ۽ڵ�
	public void add2() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		Node node = document.createElement("�ۼ�");
		node.setTextContent("39Ԫ");
		
		Node parent = document.getElementsByTagName("��").item(0);
		parent.insertBefore(node,document.getElementsByTagName("����").item(0));
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
		
	}
	
	//ɾ��xml�ĵ����ۼ۽ڵ�
	public void delete() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		Node node = document.getElementsByTagName("�ۼ�").item(0);
		node.getParentNode().removeChild(node);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document),new StreamResult(new File("src/book1.xml")));
			
	}
	
	//����xml�ĵ�����
	public void updateAttribute() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		//����xml�ĵ���Ԫ��ʱ��һ�㶼���Ԫ�ص���node���󣬵��ǳ���Ա�������node����ʹʱ����Ӧ��nodeǿת����Ӧ����
		Element book = null;
		Node node = document.getElementsByTagName("��").item(0);
		if(node.getNodeType()==Node.ELEMENT_NODE)
		{
			//�����ڵ�ת��֮ǰ��������жϽ������
			book = (Element)node;
		}
		book.setAttribute("name", "yyyyy");
		book.setAttribute("password", "123");
		book.removeAttribute("password");
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
	}
	
	//����
	public static void list(Node node)
	{
		if(node.getNodeType()== Node.ELEMENT_NODE)
		{
			System.out.println(node.getNodeName());
		}
		
		NodeList list = node.getChildNodes();
		for(int i=0; i<list.getLength(); i++)
		{
			Node child = list.item(i);
			list(child);
		}
	}
}