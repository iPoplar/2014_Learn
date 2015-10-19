package cn.bmy.web.tag;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import cn.factory.MyFactory;
import cn.factory.XMLBean;
import cm.dao.ITestDao;

public class Test {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException 
	{
		//对Factory的Test
		ITestDao dao = (ITestDao) MyFactory.getBean("impl2");
		dao.say();
		
		//对ObjectOutputStream的Test
//		XMLBean bean = new XMLBean();
//		bean.setClazz("11111");		
		//ObjectOutputStream类所读写的对象必须实现Serializable接口,ObjectOutputStream将对象写入到文件;
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e:/111"));
//		out.writeObject(bean);
		
		
		//对ObjectInputStream的Test
//		ObjectInputStream out = new ObjectInputStream(new FileInputStream("e:/111"));
//		XMLBean bean = (XMLBean) out.readObject();
//		System.out.println(bean.getClazz());
		
		//对IO流的关闭顺序的Test
		/*File file = new File("e:/111");
		FileInputStream fstream = new FileInputStream(file);
		fstream.close();
		fstream.close();*/
//		ObjectInputStream object = new ObjectInputStream(fstream);
//		object.readObject();
//		object.close();
//		fstream.close();
	}

}
