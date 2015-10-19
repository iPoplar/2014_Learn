package cn.bmy.dom4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Demo1 
{
	//读取xml文档数据a:<书名>Java就业培训教程</书名>
	@Test
	public void read() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element root = document.getRootElement();
		Element bookname = root.element("书").element("书名");
		System.out.println(bookname.getText());
	}
	
	//<书 name="yyyyyyy">
	@Test
	public void add() throws DocumentException, IOException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element price = DocumentHelper.createElement("售价");
		price.setText("19元");
		document.getRootElement().element("书").add(price);
		//格式化输出器
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book1.xml"),format);
		writer.write(document);
		writer.close();
	}
	
	@Test
	//向指定位置增加售价节点
	public void add2() throws DocumentException, IOException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element price = DocumentHelper.createElement("售价");
		price.setText("36元");
		List list = document.getRootElement().element("书").elements();
		list.add(2, price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book1.xml"),format);
		writer.write(document);
		writer.close();	}
		
	@Test
	//删除<售价>
	public void delete() throws DocumentException, IOException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element price = (Element)document.getRootElement().element("书").elements("售价").get(0);
		price.getParent().remove(price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book1.xml"),format);
		writer.write(document);
		writer.close();
	}	
	
	@Test
	public void findWithXpath() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element e = (Element) document.selectNodes("//书名").get(1);
		System.out.println(e.getText());		
	}
	
	@Test
	public void findUser() throws DocumentException
	{
		String username="bbb";
		String password="123";
		 
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/user.xml"));
		Element e = (Element) document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
		
		if(e!=null)			
		{
			System.out.println("让用户登陆成功！！");
		}
		else
		{
			System.out.println("用户名和密码不正确！！");
		}
	}
}
