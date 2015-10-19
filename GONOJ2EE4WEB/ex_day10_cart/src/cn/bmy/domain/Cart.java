package cn.bmy.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//代表购物车
public class Cart 
{
	//用于保存购物车中所有的商品
	//***购物车中的Map<String,CartItem>的设计非常重要和有要求
	//此处是购物车中的数量，当有相同的书是，变化的是数量	
	private Map<String, CartItem> map = new LinkedHashMap();
	private double price;
	
	public void add(Book book)
	{
		//???此处的是map的嵌套，还要嗨好好测试一番的
		CartItem item = map.get(book.getId());
		if(item!=null)
		{
			item.setQuantity(item.getQuantity()+1);
		}
		else
		{
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);
			
		}
	}
	
	public Map<String,CartItem> getMap()
	{
		return map;
	}

	public void setMap(Map<String, CartItem> map)
	{
		this.map = map;
	}
	
	public double getPrice()
	{
		double totalprice = 0;
		
		for(Map.Entry<String, CartItem> me : map.entrySet())
		{
			CartItem item = me.getValue();
			totalprice += item.getPrice();			
		}
		return totalprice;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
}
