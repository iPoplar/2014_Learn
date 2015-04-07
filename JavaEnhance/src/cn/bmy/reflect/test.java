package cn.bmy.reflect;

import java.lang.reflect.Field;

public class test 
{
	public static void main(String[] args) 
	{
		try 
		{
			ReflectPoint point = new ReflectPoint(1,7);
			Field y;
			y = Class.forName("cn.bmy.reflect.ReflectPoint").getField("y");
			//此处的y，只是获得了字节码
			System.out.println(y.get(point)); //在此才可以获得 7
			//此句必然报错，x是私有的
			//Field x = Class.forName("cn.itcast.corejava.ReflectPoint").getField("x");
			//暴力反射      		
			//三步曲   	一是不让你知道我有钱      二是把钱晃一下，不给用     三是暴力抢了
			//这个管你是公的私的，都拿来
			Field x = Class.forName("cn.bmy.reflect.ReflectPoint").getDeclaredField("x");
			x.setAccessible(true);//上面的代码已经看见钱了，开始抢了
			System.out.println(x.get(point));
		
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
