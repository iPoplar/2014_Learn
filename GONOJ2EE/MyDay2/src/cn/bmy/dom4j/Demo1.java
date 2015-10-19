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
	//��ȡxml�ĵ�����a:<����>Java��ҵ��ѵ�̳�</����>
	@Test
	public void read() throws DocumentException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element root = document.getRootElement();
		Element bookname = root.element("��").element("����");
		System.out.println(bookname.getText());
	}
	
	//<�� name="yyyyyyy">
	@Test
	public void add() throws DocumentException, IOException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element price = DocumentHelper.createElement("�ۼ�");
		price.setText("19Ԫ");
		document.getRootElement().element("��").add(price);
		//��ʽ�������
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book1.xml"),format);
		writer.write(document);
		writer.close();
	}
	
	@Test
	//��ָ��λ�������ۼ۽ڵ�
	public void add2() throws DocumentException, IOException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element price = DocumentHelper.createElement("�ۼ�");
		price.setText("36Ԫ");
		List list = document.getRootElement().element("��").elements();
		list.add(2, price);
		
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("UTF-8");
		
		XMLWriter writer = new XMLWriter(new FileOutputStream("src/book1.xml"),format);
		writer.write(document);
		writer.close();	}
		
	@Test
	//ɾ��<�ۼ�>
	public void delete() throws DocumentException, IOException
	{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("src/book1.xml"));
		Element price = (Element)document.getRootElement().element("��").elements("�ۼ�").get(0);
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
		Element e = (Element) document.selectNodes("//����").get(1);
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
			System.out.println("���û���½�ɹ�����");
		}
		else
		{
			System.out.println("�û��������벻��ȷ����");
		}
	}
}
