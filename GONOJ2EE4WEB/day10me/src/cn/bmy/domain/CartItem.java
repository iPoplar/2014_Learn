package cn.bmy.domain;

//cartItem����ĳ���飬����ʾ����ֶ��ٴ�
public class CartItem 
{
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
		return price;//TODO �۸��ϸ�ڴ���
	}
	public void setPrice(double price) {
		this.price = price;
	}

}
