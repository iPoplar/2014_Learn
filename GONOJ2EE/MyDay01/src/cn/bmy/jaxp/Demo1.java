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
	 * 使用jaxp操作xml文档
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 * @throws SAXException 
	 * 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException 
	{
		//1.获取工厂
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
				
		//2.产生解析器
		DocumentBuilder builder = factory.newDocumentBuilder();
		
		//3.解析xml文档，得到代表文档document
		Document document = builder.parse(new File("src/book1.xml"));
		/*//遍历
		list(document);*/
		read(document);
		
	}
	
	//得到售价结点的值
	public  static void read(Document doucment) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		NodeList list = document.getElementsByTagName("售价");
		Node price  = list.item(0);
		
		String value = price.getTextContent();
		System.out.println(value);
				
	}
	@Test
	//修改结点的值（售价）
	public void update() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		Node price  = document.getElementsByTagName("售价").item(0);
		price.setTextContent("109");
		
		//把内存中的document写到xml文档
		TransformerFactory tf = TransformerFactory.newInstance();
		//得到转换器
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
	}
	@Test
	//向指定节点中增加孩子节点（售价节点）
	public void add() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		//创建需要增加的节点
		Node price = document.createElement("售价");
		price.setTextContent("59元");
		
		//得到需要增加的节点的父亲
		Node parent = document.getElementsByTagName("书").item(0);
		//把需要增加的节点挂到父节点上
		parent.appendChild(price);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
	}
	
	//向指定位置上插入售价节点
	public void add2() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		Node node = document.createElement("售价");
		node.setTextContent("39元");
		
		Node parent = document.getElementsByTagName("书").item(0);
		parent.insertBefore(node,document.getElementsByTagName("书名").item(0));
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
		
	}
	
	//删除xml文档的售价节点
	public void delete() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		Node node = document.getElementsByTagName("售价").item(0);
		node.getParentNode().removeChild(node);
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document),new StreamResult(new File("src/book1.xml")));
			
	}
	
	//操作xml文档属性
	public void updateAttribute() throws ParserConfigurationException, SAXException, IOException, TransformerException
	{
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse(new File("src/book1.xml"));
		
		//操作xml文档的元素时，一般都会把元素当作node对象，但是程序员如果发现node不好使时，就应把node强转成相应类型
		Element book = null;
		Node node = document.getElementsByTagName("书").item(0);
		if(node.getNodeType()==Node.ELEMENT_NODE)
		{
			//在作节点转化之前，最好先判断结点类型
			book = (Element)node;
		}
		book.setAttribute("name", "yyyyy");
		book.setAttribute("password", "123");
		book.removeAttribute("password");
		
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer ts = tf.newTransformer();
		ts.transform(new DOMSource(document), new StreamResult(new File("src/book1.xml")));
	}
	
	//遍历
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