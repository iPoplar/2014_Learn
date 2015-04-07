package cn.bmy.arrguments;

import java.util.Arrays;
import java.util.List;

public class Demo1
{
	/**
	 * 测试JDK中具有可变参数的类Arrays.asList()方法。分别传多个参、传数组，传数组又传参的情况。
		注意：传入基本数据类型数组的问题。
		从JDK 5开始, Java 允许为方法定义长度可变的参数。
		语法：
		public void foo(int … args)
		{}
	注意事项：
	调用可变参数的方法时, 编译器将自动创建一个数组保存传递给方法的可变参数，因此，程序员可以在方法体中以数组的形式访问可变参数
	可变参数只能处于参数列表的最后, 所以一个方法最多只能有一个长度可变的参数
	 */
	public static void main(String[] args) 
	{
		sum(1,2,3,4,5);
		
		Integer arr[] = {1,2,3,4,5};
		sum(arr);  //如果一个方法接收可变参数，那向里面传数组也是可以的
		
		List list = Arrays.asList(1,2,3);
		System.out.println(list+"这是 Arrays.asList(1,2,3)的值");
		//打印结果：[1, 2, 3]这是 Arrays.asList(1,2,3)的值
		
		Integer arr2[] = {1,2,3,4,5};
		list = Arrays.asList(arr2);  //5
		System.out.println(list+"这是Arrays.asList(arr2)的值");
		//打印结果：[1, 2, 3, 4, 5]这是Arrays.asList(arr2)的值
		
		//注意的问题
		int a[] = {1,2,3};
		list = Arrays.asList(a);  //1
		System.out.println(list+"这是Arrays.asList(a)的值");
		//打印结果：[[I@c9d92c]这是Arrays.asList(a)的值
		
		sum2(1,2,3,4,5);
	}
	
	public static void sum(Integer ... args)
	{
		//可变参数在编程时当成数组即可
		int sum = 0;
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum+"这是sum函数中的sum的值");
		//打印结果：15这是sum函数中的sum的值
	}
	
	//注意
	public static void sum2(Integer num,Integer ... args)
	{
		//可变参数在编程时当成数组即可
		int sum = 0;
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum+"这是sum2函数中的sum的值");
		//打印结果：14这是sum2函数中的sum的值
	}
}
