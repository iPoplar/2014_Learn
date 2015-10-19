package cn.bmy.huge;

import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

public class BigDataIntegerMain
{
	public static void main(String[] args) 
	{
		BigDataInteger num1 = new BigDataInteger("9999999999999999999999");
		BigDataInteger num2 = new BigDataInteger("111111111111111");
		BigDataInteger AddResult = num1.add(num2);
		BigDataInteger SubtractResult = num1.subtract(num2);
		BigDataInteger multiplyResult = num1.multiply(num2);	
		System.out.println(AddResult+"@@AddResult");
		System.out.println(SubtractResult + "@@SubtractResult");
		System.out.println(multiplyResult+"*");
	}

	
}
