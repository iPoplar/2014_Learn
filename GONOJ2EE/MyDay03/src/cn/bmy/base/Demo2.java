package cn.bmy.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo2 
{
	/**
	 * 增强for循环
	 */
	@Test
	public void testArray()
	{
		Integer arr[] = {1, 2, 3, 4	};
		
		/*//传统做法
		for(int i = 0; i < arr.length; i++)
		{
			System.out.println(arr[i]);
		}
		*/
		//jdk5的做法
		for(int temp : arr)
		{
			System.out.println(temp);
		}
	}
	
	@Test
	public void testList()
	{
		//集合------Collection(list set) Map
		/********************************************************************
		 * Collection 
		 * 			--set:无序  不允许有重复	HashSet LinkedHashSet
		 * 			--list:有序  允许重复		ArrayList LinkedList vector
		 * Map 
		 * 			HashMap
		 * 			HashTable
		 * 
		 ********************************************************************/
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			int temp = (Integer)it.next();
			System.out.println(temp);
		}
		
		System.out.println("----------");
		
		for(Object temp :list)
		{
			int num = (Integer) temp;
			System.out.println(num);
		}
		
	}
	
	public void testMap()
	{
		Map map = new HashMap();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		
		//传统做法1
		Set set = map.keySet();
		Iterator it = set.iterator();
		while(it.hasNext())
		{
			String key = (String)it.next();
			String value = (String) map.get(key);
			System.out.println(key + "=" + value);
		}
		
		System.out.println("------------------");
		
		//传统做法2
		Set set2 = map.entrySet();
		it = set2.iterator();
		while(it.hasNext())
		{
			
		}
		
		//增强for取map数据
		for(Object obj : map.entrySet())
		{
			Map.Entry me = (Map.Entry)it.next();
			String key = (String) me.getKey();
			String value = (String) me.getValue();
			System.out.println(key + "=" + value);
		}
	}
	
	/**
	 * 增强for的注意事项
	 * 增强for只适合取数据，不能操作数组或集合
	 */
	@Test
	public void test1()
	{
		Integer arr[] = {1, 2, 3};
		
		for(int i : arr)
		{
			i = 10;
		}
		
		System.out.println(arr[2]);
		
		for(int i = 0; i < arr.length; i++)
		{
			arr[i] = 10;
		}
	}
	
	@Test
	public void test2()
	{
		List list = new ArrayList();
		list.add(1);
		
		for(Object obj : list)
		{
			obj = 3;			
		}
	}
	
	@Test
	public void test3()
	{
		/***********************************************************************
		 *以下代码会抛：
		 *java.util.ConcurrentModificationException
		 **********************************************************************/
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			int temp = (Integer)it.next();
			System.out.println(temp);
			list.add(3);
		}
	}
	//在对集合进行迭代的过程中，默认情况下是不能对集合进行增删改操作的，若果想
	//执行此类操作，调用迭代器的方法
	@Test
	public void test4()
	{
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		ListIterator it = list.listIterator();
		while(it.hasNext())
		{
			int temp = (Integer)it.next();
			System.out.println(temp);
			it.add(3);
		}
		
		System.out.println(list.size());
	}
	
}
