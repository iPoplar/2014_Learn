package cn.bmy;

import java.math.BigDecimal;

public class CalculatorBean 
{
	private double firstNum;
	private double secondNum;
	private char operator = '+';  //int char byte short 
	private double result;
	
	public double getFirstNum() {
		return firstNum;
	}
	public void setFirstNum(double firstNum) {
		this.firstNum = firstNum;
	}
	public double getSecondNum() {
		return secondNum;
	}
	public void setSecondNum(double secondNum) {
		this.secondNum = secondNum;
	}
	public char getOperator() {
		return operator;
	}
	public void setOperator(char operator) {
		this.operator = operator;
	}
	public double getResult() {
		return result;
	}
	public void setResult(double result) {
		this.result = result;
	}
	
	
	public void calculate()
	{
		switch(this.operator)
		{
			case'+':
			{
				this.result = this.firstNum + this.secondNum;
				break;
			}
			case'-':
			{
				this.result = this.firstNum - this.secondNum;
				break;
			}
			case'*':
			{
				this.result = this.firstNum * this.secondNum;
				break;
			}
			case'/':
			{
				if(this.secondNum==0)
				{
					throw new RuntimeException("��������Ϊ0");
				}
				this.result = this.firstNum / this.secondNum;
				
				//��������
				this.result = new BigDecimal(this.result).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
				
				break;
			}
			default:
				throw new RuntimeException("�Բ��𣬴����������Ƿ�����");		
		}		
	}
	
}