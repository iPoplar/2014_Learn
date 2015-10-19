package cn.bmy.domain;

import java.util.LinkedHashMap;
import java.util.Map;

//�����ﳵ
public class Cart 
{
	//���ڱ��湺�ﳵ�����е���Ʒ
	//***���ﳵ�е�Map<String,CartItem>����Ʒǳ���Ҫ����Ҫ��
	//�˴��ǹ��ﳵ�е�������������ͬ�����ǣ��仯��������	
	private Map<String, CartItem> map = new LinkedHashMap();
	private double price;
	
	public void add(Book book)
	{
		//???�˴�����map��Ƕ�ף���Ҫ�˺úò���һ����
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
