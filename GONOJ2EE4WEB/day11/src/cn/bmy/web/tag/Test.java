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
		//��Factory��Test
		ITestDao dao = (ITestDao) MyFactory.getBean("impl2");
		dao.say();
		
		//��ObjectOutputStream��Test
//		XMLBean bean = new XMLBean();
//		bean.setClazz("11111");		
		//ObjectOutputStream������д�Ķ������ʵ��Serializable�ӿ�,ObjectOutputStream������д�뵽�ļ�;
//		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("e:/111"));
//		out.writeObject(bean);
		
		
		//��ObjectInputStream��Test
//		ObjectInputStream out = new ObjectInputStream(new FileInputStream("e:/111"));
//		XMLBean bean = (XMLBean) out.readObject();
//		System.out.println(bean.getClazz());
		
		//��IO���Ĺر�˳���Test
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
