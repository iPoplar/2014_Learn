package cn.bmy.arrguments;

import java.util.Arrays;
import java.util.List;

public class Demo1
{
	/**
	 * ����JDK�о��пɱ��������Arrays.asList()�������ֱ𴫶���Ρ������飬�������ִ��ε������
		ע�⣺�����������������������⡣
		��JDK 5��ʼ, Java ����Ϊ�������峤�ȿɱ�Ĳ�����
		�﷨��
		public void foo(int �� args)
		{}
	ע�����
	���ÿɱ�����ķ���ʱ, ���������Զ�����һ�����鱣�洫�ݸ������Ŀɱ��������ˣ�����Ա�����ڷ����������������ʽ���ʿɱ����
	�ɱ����ֻ�ܴ��ڲ����б�����, ����һ���������ֻ����һ�����ȿɱ�Ĳ���
	 */
	public static void main(String[] args) 
	{
		sum(1,2,3,4,5);
		
		Integer arr[] = {1,2,3,4,5};
		sum(arr);  //���һ���������տɱ�������������洫����Ҳ�ǿ��Ե�
		
		List list = Arrays.asList(1,2,3);
		System.out.println(list+"���� Arrays.asList(1,2,3)��ֵ");
		//��ӡ�����[1, 2, 3]���� Arrays.asList(1,2,3)��ֵ
		
		Integer arr2[] = {1,2,3,4,5};
		list = Arrays.asList(arr2);  //5
		System.out.println(list+"����Arrays.asList(arr2)��ֵ");
		//��ӡ�����[1, 2, 3, 4, 5]����Arrays.asList(arr2)��ֵ
		
		//ע�������
		int a[] = {1,2,3};
		list = Arrays.asList(a);  //1
		System.out.println(list+"����Arrays.asList(a)��ֵ");
		//��ӡ�����[[I@c9d92c]����Arrays.asList(a)��ֵ
		
		sum2(1,2,3,4,5);
	}
	
	public static void sum(Integer ... args)
	{
		//�ɱ�����ڱ��ʱ�������鼴��
		int sum = 0;
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum+"����sum�����е�sum��ֵ");
		//��ӡ�����15����sum�����е�sum��ֵ
	}
	
	//ע��
	public static void sum2(Integer num,Integer ... args)
	{
		//�ɱ�����ڱ��ʱ�������鼴��
		int sum = 0;
		for(int arg : args)
		{
			sum += arg;
		}
		System.out.println(sum+"����sum2�����е�sum��ֵ");
		//��ӡ�����14����sum2�����е�sum��ֵ
	}
}
