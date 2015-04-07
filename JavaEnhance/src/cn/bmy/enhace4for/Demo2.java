package cn.bmy.enhace4for;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class Demo2
{
	/**增强for的注意事项
	 * 
	 * 增强for只适合取数据，不能操作数组或集合
	 */

	@Test
	public void test1() 
	{
		Integer arr[] = { 1, 2, 3 };

		for (int i : arr) 
		{
			i = 10;
		}

		System.out.println("这是增强for循环设置数组中的值:"+arr[0]);

		for (int i = 0; i < arr.length; i++) 
		{
			arr[i] = 10;
		}
		System.out.println("这是传统方法设置数组中的值:"+arr[0]);
		
		//增强for循环不能设置数组中的值
	}

	@Test
	public void test2() 
	{
		List list = new ArrayList();
		list.add(1);

		System.out.println("这是list的值："+ list);
		for (Object obj : list) 
		{
			obj = 3;
			System.out.println("这是通过增强for循环操作后的obj的值："+ obj);
		}
		System.out.println("这是通过增强for循环操作后的list的值："+ list);
	}

	@Test
	public void test3() 
	{
		/***********************************************************************
		 *以下代码会抛：
		 *java.util.ConcurrentModificationException
		 * 
		 **********************************************************************/
		List list = new ArrayList();
		list.add(1);
		list.add(2);

		Iterator it = list.iterator();
		while (it.hasNext()) 
		{
			int temp = (Integer) it.next();
			System.out.println(temp+"这是temp的值");
			list.add(3);
		}
	}	
	
	//在对集合进行迭代的过程中，默认情况下是不能对集合进行增删改操作的，如果想执行此类操作，请调用迭代器的方法
	@Test
	public void test4()
	{
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		ListIterator it = list.listIterator();
		System.out.println(list.size()+"第一次的");
		//打印结果:2第一次的
		while(it.hasNext())
		{
			int temp = (Integer) it.next();
			System.out.println(temp+"这是temp的值");
			it.add(3);
		}
		
		System.out.println(list.size());
		//打印结果:4
	}
	
}
