package cn.bmy.dao;

import java.util.Map;

import cn.bmy.db.MyDb;
import cn.bmy.domain.Book;

public class BookDao 
{
	public Map getAll()
	{
		return MyDb.getAll();
	}
	
	public Book find(String id)
	{
		return (Book) MyDb.getAll().get("id");
	}

}
