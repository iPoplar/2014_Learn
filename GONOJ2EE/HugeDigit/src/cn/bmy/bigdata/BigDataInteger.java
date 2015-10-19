package cn.bmy.bigdata;

import java.util.ArrayList;
import java.util.List;


public class BigDataInteger 
{
	public List<Integer> value;
	
	/**
	 * 构造函数
	 * @param val
	 */
	public BigDataInteger(String val)
	{
		//取数值部分
		String v = val.charAt(0) == '-' ? val.substring(1) : val;
		//每四个字元为一个int
		value = new ArrayList<>();
		for(int i=v.length()-4; i>-4; i-=4)
		{
			value.add(Integer.parseInt(v.substring(i >= 0 ? i : 0, i + 4)));
		}
		//补位，位数以8为单位
		int valueLength = (value.size() / 8 + 1) * 8;
		for(int i=value.size(); i<valueLength; i++)
		{
			value.add(0);
		}
		//负数转补数表示
		value = val.charAt(0) == '-' ? toComplement(value) : value;
	}
	
	/**
	 * 
	 * @param value
	 */
	private BigDataInteger(List<Integer> value)
	{
		this.value = value;
	}
	
	/**
	 *  处理负数的补数
	 * @param v 已经经过4位一组的处理好过的数值
	 * @return
	 */
	public static List<Integer> toComplement(List<Integer> v)
	{
		List<Integer> comp = new ArrayList<>();
		
		for(Integer i : v)
		{
			comp.add(9999-i);			
		}
		comp.set(0, comp.get(0)+1);
		
		return comp;		
	}

	/**
	 *  判断是否为负数
	 * @param list
	 * @return
	 */
	private static boolean isNegative(List<Integer> list) 
	{
		return getLast(list)== 9999;		
	}
	/**
	 * 获取最后一个数值 
	 * @param list
	 * @return
	 */
	
	private static Integer getLast(List<Integer> list)
	{
		return list.get(list.size()-1);
	}
	
	/**
	 * 
	 * @param original
	 * @param newlength
	 * @return
	 */
	private static List<Integer> copyOf(List<Integer> original, int newlength) 
	{
		List<Integer> v = new ArrayList<>(original);
		for(int i = v.size(); i < newlength; i++)
		{
			v.add(isPositive(original) ? 0 : 9999);
		}
		return v;
	}
	
	/**
	 * 
	 * @param list
	 * @return
	 */
	private static boolean isPositive(List<Integer> list)
	{
		return getLast(list) == 0;
	}
	
	public String toString()
	{
		//一律以正数表示
		List<Integer> v = isNegative(value) ? toComplement(value) : value;
		StringBuilder builder = new StringBuilder();
		for(int i=v.size() -1; i>-1; i--)
		{
			builder.append(String.format("%04d", v.get(i)));
		}
		//移去前端的0，负数补负号
		while(builder.length()>0 && builder.charAt(0) == '0')
		{
			builder.deleteCharAt(0);
		}
			
		return builder.length() == 0 ? "0" : isNegative(value) ? builder.insert(0, '-').toString() : builder.toString();
		
	}
	
	
	/**
	 * 巨大数加法
	 * @param data
	 * @return
	 */
	public BigDataInteger add(BigDataInteger data)
	{
		if(isNegative(data.value))
		{
			return subtract(new BigDataInteger(toComplement(data.value)));
		}
		
		// 对齐位数
		int length = Math.max(value.size(), data.value.size());
		List<Integer> op1 =  copyOf(value, length);
		List<Integer> op2 = copyOf(data.value, length);
		List<Integer> result = new ArrayList<>();
		
		//进位
		int carry = 0;
		for(int i=0; i<length-1; i++)
		{
			int c = op1.get(i) + op2.get(i) + carry;
			if(c < 10000)
			{
				carry = 0; 
			}
			else
			{
				c -= 10000;
				carry = 1;
			}
			
			result.add(c);
		}
		
		if(carry == 1)
		{
			//溢位处理
			if(isPositive(op1))
			{
				result.add(1);
			}
			else //负数加法运算溢位就是0
			{
				result.clear();
			}
			
			for(int i=0; i < 8; i++)
			{
				//自动增加8位数
				result.add(0);
			}
		}
		else//补位，正数补0，负数补9999
		{
			result.add(isPositive(op1) ? 0 : 9999);
		}
		
		return new BigDataInteger(result);
	}
	
	public BigDataInteger subtract(BigDataInteger data)
	{
		if(isNegative(data.value))
		{
			return add(new BigDataInteger(toComplement(data.value)));
		}
		//对齐位数
		int length = Math.max(value.size(), data.value.size());
		List<Integer> op1 = copyOf(value, length);
		List<Integer> op2 = copyOf(data.value, length);
		List<Integer> result = new ArrayList<>();
		
		int borrow = 0;
		for(int i=0; i<length -1; i++)
		{
			int c = op1.get(i) - op2.get(i) - borrow;
			if(c > -1)
			{
				borrow = 0;
			}
			else//借位
			{
				c += 10000;
				borrow = 1;
			}
			 result.add(c);
		}
		
		if(borrow == 1)
		{
			//溢位处理
			if(isNegative(op1))
			{
				result.add(9998);
			}
			else
			{	//正数的减法运算溢位就是0
				result.clear();
			}
			
			for(int i=0; i<8; i++)
			{	//自动增加8位数
				result.add(9999);
			}
		}
		else
		{
			result.add(isNegative(result) ? 9999 : 0);
		}
		
		return new BigDataInteger(result);
	}
	
	//右运算元为int 时的乘法运算，内部使用，两个运算元都都要是正数
	private BigDataInteger multiply(int val, int shift)
	{
		List<Integer> result = new ArrayList<>();
		
		for(int i=0; i < shift; i++)
		{	//位移补0
			result.add(0);
		}
		
		int carry = 0;
		for(int i=0; i<value.size()-1; i++)
		{
			int tmp = value.get(i) * val + carry;
			result.add(tmp % 10000);
			carry = tmp / 10000;
		}
		
		if(carry != 0)
		{
			result.add(carry);
			for(int i=0; i<8; i++)
			{
				result.add(0);
			}			
		}
		else
		{
			result.add(0);
		}
		
		return new BigDataInteger(result);
	}
	
}
