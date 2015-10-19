package cn.bmy.service;

import java.util.Map;

import cn.bmy.dao.BookDao;
import cn.bmy.domain.Book;
import cn.bmy.domain.Cart;
import cn.bmy.exception.CartNotFoundException;

public class BusinessService 
{
	BookDao dao = new BookDao();
	
	//列出所有书的服务
	public Map getAllBook()
	{
		return dao.getAll();
	}
	
	public void buybook(String bookid, Cart cart)
	{
		Book book = dao.find(bookid);
		cart.add(book);
	}
	
	public void deleteBook(String bookid, Cart cart) throws CartNotFoundException
	{
		//****？？为什么在此处设置为异常——这是一个学问！
		if(cart==null)
		{
			throw new CartNotFoundException("购物车为空！！！");
		}
		
		Map map = cart.getMap();
		map.remove(bookid);
	}
	
	public void clearCart(Cart cart) throws CartNotFoundException
	{
		if(cart == null)
		{
			throw new CartNotFoundException("购物车为空!!");
		}
		
		cart.getMap().clear();
	}
}

