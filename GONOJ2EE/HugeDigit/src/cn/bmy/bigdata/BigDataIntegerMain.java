package cn.bmy.bigdata;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class BigDataIntegerMain
{
	public static void main(String[] args) 
	{
		BigDataInteger num1 = new BigDataInteger("1234567890123456789");
		BigDataInteger num2 = new BigDataInteger("-12345678901234567");
		BigDataInteger AddResult = num1.add(num2);
		BigDataInteger SubtractResult = num1.subtract(num2);
		System.out.println(AddResult+"@@AddResult");
		System.out.println(SubtractResult + "@@SubtractResult");
	}

	
}
