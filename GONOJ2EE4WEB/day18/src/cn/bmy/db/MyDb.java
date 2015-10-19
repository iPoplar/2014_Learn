package cn.bmy.db;

import java.util.ArrayList;
import java.util.List;

import cn.bmy.domain.User;

public class MyDb 
{
	private static List list = new ArrayList();
	
	static 
	{
		list.add(new User("aaa","123"));
		list.add(new User("bbb","123"));
		list.add(new User("vvv","123"));
	}
	
	public static List getAll()
	{
		return list;
	}

}
