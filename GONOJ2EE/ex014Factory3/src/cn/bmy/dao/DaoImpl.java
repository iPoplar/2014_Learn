package cn.bmy.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.junit.Test;

import cn.bmy.utils.XmlUtils;

public class DaoImpl 
{
	public static   Map<String,String> map=new  HashMap<String,String>();
	static 
	{		
			Document document;
			try 
			{
				document = XmlUtils.getDocument();
				Element root = document.getRootElement();
			
			System.out.println(root.getName());//exam
			
			List<Element> l = root.elements();
			for(int j = 0; j < l.size(); j++)
			{	//针对1个大标签说的操作
				System.out.println(l.get(j).getName());//student		
				Element student = l.get(j);
				System.out.println(student.attributeValue("examid")+"%%%examid");
				System.out.println(student.attributeValue("idcard")+"%%%idcard");
				map.put("examid", student.attributeValue("examid"));
				map.put("idcard", student.attributeValue("idcard"));
				List<Element> sl = student.elements();
				for(Element i : sl )
				{
					System.out.println(i.getName());
					System.out.println(i.getText());
					map.put(i.getName(), i.getText());
				}			
			}
			System.out.println("*************================================================*************");
					
			} catch (DocumentException e) {
				e.printStackTrace();
			}
	}	
	
	@Test
	public static void find(String find) throws DocumentException
	{	
		//对所有数据的收集
		  for (Map.Entry<String, String> m : map.entrySet())
		  { 			  
             System.out.println("key:"+m.getKey()+" value"+m.getValue()+"XXXXXXXXXXXXXXX");
             System.out.println("*************================================================*************");
              if (m.getValue().equals(find)) 
  			{
  				System.out.println(m.getKey()+"%%%%%%%%%%%########33");
  				System.out.println(map.entrySet()+"$$$");
  			}
           }  
		  
		 //通过value获取key——>has problem!!!
	/*	Set set = map.entrySet();
		Iterator it = set.iterator();
		System.out.println(it+"##这是it！！！");
		
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			if (entry.getValue().equals(find)) 
			{
				System.out.println(entry.getKey()+"%%%%%%%%%%%########33");
				System.out.println(set+"$$$");
			}
		}*/
	}
	  
	public static void main(String[] args) throws DocumentException
	{
		String find ="22222";
		find(find);
	}
}
