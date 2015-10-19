package cn.itcast.service;

import java.util.Map;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.domain.Cart;
import cn.itcast.domain.CartItem;
import cn.itcast.exception.CartNotFoundException;

public class BusinessService {
	
	BookDao dao = new BookDao();
	
	//�г�������ķ���
	public Map getAllBook(){
		return dao.getAll();
	}

	public void buybook(String bookid, Cart cart) {
		Book book = dao.find(bookid);
		cart.add(book);
	}

	public void deleteBook(String bookid, Cart cart) throws CartNotFoundException {
		
		if(cart==null){
			throw new CartNotFoundException("���ﳵΪ�գ���");
		}
		
		Map map = cart.getMap();
		map.remove(bookid);
	}

	public void clearCart(Cart cart) throws CartNotFoundException {
		if(cart==null){
			throw new CartNotFoundException("���ﳵΪ�գ���");
		}
		
		cart.getMap().clear();
		
	}

	public void updateCart(Cart cart, String bookid, int quantity) throws CartNotFoundException {

		if(cart==null){
			throw new CartNotFoundException("���ﳵΪ�գ���");
		}
		CartItem item = cart.getMap().get(bookid);
		item.setQuantity(quantity);
		
	}
	
}
