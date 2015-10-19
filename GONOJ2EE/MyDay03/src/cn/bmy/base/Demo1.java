package cn.bmy.base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1 
{
	/*
	 * 基本数据类型的包装类
	 * byte short int long float double boolean char
	 * Byte Short Integer Long ................Character
	 */
	public static void main(String[] args) 
	{
		Integer i = 1; 	//装箱   Integer i = new Integer(1);
		int j  = i; //拆箱
		
		//典型应用
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			int k = (Integer)it.next();//拆箱
		}
		
	}
}
