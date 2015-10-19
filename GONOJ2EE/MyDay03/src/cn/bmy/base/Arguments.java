package cn.bmy.base;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class Arguments 
{
	public static void main(String[] args) 
	{
		sum(1,2,3,4,5);
		
		Integer arr[] = {1,2,3};
		sum(arr);//���һ�������ǽ��ܿɱ��������ô����ߴ�����Ҳ�ǿ��Ե�
		
		Integer arr2[] = {1,2,3,4,5};
		List list = Arrays.asList(arr2);//JVM��Ϊ1��Ԫ��
		System.out.println(list);
		
		list = Arrays.asList(1,2,3);
		System.out.println(list);
		
		//ע�������
		int a[] = {1,2,3};
		list = Arrays.asList(a);//��Ϊ1��Ԫ��
		System.out.println(list);
		
		sum2(1,2,3,4,5);
		
		
	}
	
	public static void sum2(Integer num, Integer ... args)
	{
		//�ɱ�����ڱ��ʱ�������鼴��
		int sum = 0;
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum);
	}
	
	@Test
	public static  void sum(Integer ... args)
	{
		
		int sum = 0; 
		for(int arg : args)
		{
			sum+=arg;
			System.out.println(sum+"@@@");
		}
		System.out.println(sum);
	}	
	
	//zע�⣬
	public static void sum4(Integer ... args)
	{
		//�ɱ�����ڱ��ʱ�������鼴��
		int sum = 0; 
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum);
	}
	
}
