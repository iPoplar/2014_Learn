package cn.itcast.db;

import java.util.LinkedHashMap;
import java.util.Map;

import cn.itcast.domain.Book;


//ģ�����ݿ�
public class MyDb {

	private static Map<String,Book> map = new LinkedHashMap();
	
	static{
		map.put("1", new Book("1","javaweb����","����",20,"һ���������"));
		map.put("2", new Book("2","jdbc����","����",30,"һ��jdbc����"));
		map.put("3", new Book("3","spring����","����",50,"һ���൱�������"));
		map.put("4", new Book("4","hibernate����","��١",56,"һ��١١����"));
		map.put("5", new Book("5","struts����","�ϱ�",40,"һ���������"));
		map.put("6", new Book("6","ajax����","����",50,"һ�����ŵ���"));
	}
	
	public static Map getAll(){
		return map;
	}
	
	
}
