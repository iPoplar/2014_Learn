package cn.bmy.enhace4for;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class Demo2
{
	/**��ǿfor��ע������
	 * 
	 * ��ǿforֻ�ʺ�ȡ���ݣ����ܲ�������򼯺�
	 */

	@Test
	public void test1() 
	{
		Integer arr[] = { 1, 2, 3 };

		for (int i : arr) 
		{
			i = 10;
		}

		System.out.println("������ǿforѭ�����������е�ֵ:"+arr[0]);

		for (int i = 0; i < arr.length; i++) 
		{
			arr[i] = 10;
		}
		System.out.println("���Ǵ�ͳ�������������е�ֵ:"+arr[0]);
		
		//��ǿforѭ���������������е�ֵ
	}

	@Test
	public void test2() 
	{
		List list = new ArrayList();
		list.add(1);

		System.out.println("����list��ֵ��"+ list);
		for (Object obj : list) 
		{
			obj = 3;
			System.out.println("����ͨ����ǿforѭ���������obj��ֵ��"+ obj);
		}
		System.out.println("����ͨ����ǿforѭ���������list��ֵ��"+ list);
	}

	@Test
	public void test3() 
	{
		/***********************************************************************
		 *���´�����ף�
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
			System.out.println(temp+"����temp��ֵ");
			list.add(3);
		}
	}	
	
	//�ڶԼ��Ͻ��е����Ĺ����У�Ĭ��������ǲ��ܶԼ��Ͻ�����ɾ�Ĳ����ģ������ִ�д������������õ������ķ���
	@Test
	public void test4()
	{
		List list = new ArrayList();
		list.add(1);
		list.add(2);
		
		ListIterator it = list.listIterator();
		System.out.println(list.size()+"��һ�ε�");
		//��ӡ���:2��һ�ε�
		while(it.hasNext())
		{
			int temp = (Integer) it.next();
			System.out.println(temp+"����temp��ֵ");
			it.add(3);
		}
		
		System.out.println(list.size());
		//��ӡ���:4
	}
	
}
