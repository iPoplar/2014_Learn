package cn.bmy.service;

import java.util.Map;

import cn.bmy.dao.BookDao;
import cn.bmy.domain.Book;
import cn.bmy.domain.Cart;
import cn.bmy.exception.CartNotFoundException;

public class BusinessService 
{
	BookDao dao = new BookDao();
	
	//�г�������ķ���
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
		//****����Ϊʲô�ڴ˴�����Ϊ�쳣��������һ��ѧ�ʣ�
		if(cart==null)
		{
			throw new CartNotFoundException("���ﳵΪ�գ�����");
		}
		
		Map map = cart.getMap();
		map.remove(bookid);
	}
	
	public void clearCart(Cart cart) throws CartNotFoundException
	{
		if(cart == null)
		{
			throw new CartNotFoundException("���ﳵΪ��!!");
		}
		
		cart.getMap().clear();
	}
}

