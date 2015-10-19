package cn.bmy.dao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Dao
{
	//������ͨ��java�࣬����Դ��Ҫ������Ҫдʱ���õ�URL���ٲ���
	//��ȡ��Դ�ļ�����������Դ�ļ�
		public void run() throws IOException
		{
			URL url = this.getClass().getClassLoader().getResource("db.properties");
			String path = url.getPath();
			
			FileInputStream in = new FileInputStream(path);
			FileOutputStream out = new FileOutputStream(path);
			
			Properties prop = new Properties();
			prop.load(in);
			
			System.out.println(prop.size());
			
			prop.setProperty("name","bmy");
			//��prop.load()������������ݴ洢
			prop.store(out,"");
		}

}
