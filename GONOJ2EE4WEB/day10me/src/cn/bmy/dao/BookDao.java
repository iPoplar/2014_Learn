package cn.bmy.dao;

import java.util.Map;

import cn.bmy.db.Db;
import cn.bmy.domain.Book;


public class BookDao 
{
	public Map getAll()
	{
		return Db.getAll(); 
	}
	
	public Book find(String id)
	{
		return (Book) Db.getAll().get(id);
	}
}

