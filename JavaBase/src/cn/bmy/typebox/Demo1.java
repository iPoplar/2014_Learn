package cn.bmy.typebox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1
{
	/**自动拆箱/装箱（JDK5.0的语法）
	 * 
	 * 基本数据类型的包装类
	 *	byte short int long float double boolean char
	 *	Byte Short Integer  Long................  Character
	 */
	public static void main(String[] args)
	{		
		/** 把一个基本数据类型直接赋给对应的包装类变量,
		 *  或者赋给 Object 类型的变量，这个过程称之为自动装箱。
		 */
		Integer i = 1;  //装箱   Integer i = new Integer(1);
		
		int j = i;  //折箱
		
		//典型应用
		List list = new ArrayList();
		list.add(1);   //装箱  Integer
		list.add(2);
		int m = (Integer)list.get(0);
			
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			int k = (Integer)it.next();  //折箱
		}
	}

}
