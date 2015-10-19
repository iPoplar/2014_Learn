package cn.bmy.service;

import java.util.Map;

import cn.bmy.dao.BookDao;
import cn.bmy.domain.Book;
import cn.bmy.domain.Cart;
import cn.bmy.domain.CartItem;
import cn.bmy.exception.CartNotFoundException;

public class BusinessService 
{
	BookDao dao = new BookDao();
	
	public Map getAllBook()
	{
		return dao.getAll();
	}
	
	public void buyBook(String bookid, Cart cart)
	{
		Book book = dao.find(bookid);
		cart.add(book);
	}
	
	public void deleteBook(String bookid, Cart cart) throws CartNotFoundException
	{
		if(cart==null)
		{
			throw new CartNotFoundException("购物车为空！！");
		}
	
		Map map = cart.getMap();
		map.remove(bookid);
	}
	
	public void clearCart(Cart cart) throws CartNotFoundException
	{
		if(cart==null)
		{
			throw new CartNotFoundException("购物车为空！！");
		}
		
		cart.getMap().clear();
	}
	
	public void updateCart(String bookid, Cart cart, int quantity) throws CartNotFoundException
	{
		if(cart==null)
		{
			throw new CartNotFoundException("购物车为空！！");
		}
		
		CartItem item = cart.getMap().get(bookid);
		item.setQuantity(quantity);
		
	}
}
