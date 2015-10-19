package cn.itcast.domain;

//cartItem代表某本书，并表示书出现多少次
public class CartItem {

	private Book book;
	private int quantity;
	private double price;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return book.getPrice()*this.quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
}
