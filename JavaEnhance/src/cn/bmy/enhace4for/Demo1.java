package cn.bmy.enhace4for;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.junit.Test;

public class Demo1 {

	/**增强for循环
	 * 
	 * 引入增强for循环的原因：在JDK5以前的版本中，
	 * 遍历数组或集合中的元素，需先获得数组的长度或集合的迭代器，比较麻烦！
	 * 
	 * 增强for循环只能用在数组、或实现Iterator接口的集合类上
	 * 
	 * 语法格式：                                              
	 *	for(变量类型 变量　：需迭代的数组或集合)
	 *	{}
	 * 
	 */

	@Test
	public void testArray()
	{
		Integer arr[] = { 1, 2, 3, 4 };

		// 传统做法
		for (int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}

		// jdk5的做法
		for (int temp : arr)
		{
			System.out.println(temp);
		}
	}

	@Test
	public  void testList() 
	{
		// 集合-------Collection(list set) Map
		/***********************************************************************
		 * Collection
		 * 		---set :无序 不允许有重复  HashSet LinkedHashSet
		 * 		---list：有序 允许有重复  ArrayList LinkedList vector
		 * 
		 * Map 
		 * 		HashMap
		 * 		HashTable
		 * 
		 **********************************************************************/
		
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			int temp = (Integer)it.next();
			System.out.println(temp+"这是temp的值");
		}
		
		System.out.println("--------------------");
		
		for(Object temp : list)
		{
			int num = (Integer)temp;
			System.out.println(num+"这是num的值");
		}
	}
	
	@Test
	public void testMap()
	{
		Map map = new HashMap();
		map.put("a", "aaaa");
		map.put("b", "bbbb");
		map.put("c", "cccc");
		
		//传统做法1
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			String key = (String)it.next();
			String value = (String) map.get(key);
			System.out.println("这是做法1map.keySet():"+key + "=" + value);
		}		
		System.out.println("---------------------");
		
		//传统做法2
		Set set2 = map.entrySet();
		it = set2.iterator();
		while(it.hasNext())
		{
			Map.Entry me = (Map.Entry) it.next();
			String key = (String) me.getKey();
			String value = (String) me.getValue();
			System.out.println("这是做法2 map.entrySet():"+key + "=" + value);
		}
		
		System.out.println("---------------------");
		
		//增强for取map数据
		for(Object obj : map.entrySet())
		{
			Map.Entry me = (Map.Entry) obj;
			String key = (String) me.getKey();
			String value = (String) me.getValue();
			System.out.println("这是增强for取map数据的做法:"+key + "=" + value);
		}		
	}

}
