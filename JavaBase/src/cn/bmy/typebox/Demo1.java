package cn.bmy.typebox;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo1
{
	/**�Զ�����/װ�䣨JDK5.0���﷨��
	 * 
	 * �����������͵İ�װ��
	 *	byte short int long float double boolean char
	 *	Byte Short Integer  Long................  Character
	 */
	public static void main(String[] args)
	{		
		/** ��һ��������������ֱ�Ӹ�����Ӧ�İ�װ�����,
		 *  ���߸��� Object ���͵ı�����������̳�֮Ϊ�Զ�װ�䡣
		 */
		Integer i = 1;  //װ��   Integer i = new Integer(1);
		
		int j = i;  //����
		
		//����Ӧ��
		List list = new ArrayList();
		list.add(1);   //װ��  Integer
		list.add(2);
		int m = (Integer)list.get(0);
			
		Iterator it = list.iterator();
		while(it.hasNext())
		{
			int k = (Integer)it.next();  //����
		}
	}

}
