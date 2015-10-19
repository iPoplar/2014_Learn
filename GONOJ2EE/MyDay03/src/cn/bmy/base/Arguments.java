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
		sum(arr);//如果一个方法是接受可变参数，那么向里边传数组也是可以的
		
		Integer arr2[] = {1,2,3,4,5};
		List list = Arrays.asList(arr2);//JVM认为1个元素
		System.out.println(list);
		
		list = Arrays.asList(1,2,3);
		System.out.println(list);
		
		//注意的问题
		int a[] = {1,2,3};
		list = Arrays.asList(a);//认为1个元素
		System.out.println(list);
		
		sum2(1,2,3,4,5);
		
		
	}
	
	public static void sum2(Integer num, Integer ... args)
	{
		//可变参数在编程时当成数组即可
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
	
	//z注意，
	public static void sum4(Integer ... args)
	{
		//可变参数在编程时当成数组即可
		int sum = 0; 
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum);
	}
	
}
