package cn.bmy.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo1 {

	/**JDK5��ǰ�����󱣴浽�����оͻ�ʧȥ�����ԣ�ȡ��ʱͨ��Ҫ����Ա�ֹ��������͵�ǿ��ת����
	 * �������ɱ���ͻ����������һЩ��ȫ�����⡣����>���͵����þ���������
	 * 
	 * JDK5�еķ����������Ա�ڱ�д���ϴ���ʱ�������Ƽ��ϵĴ������ͣ��Ӷ���ԭ����������ʱ���ܷ������⣬
	 * ת��Ϊ����ʱ�����⣬�Դ���߳���Ŀɶ��Ժ��ȶ���(�����ڴ��ͳ����и�Ϊͻ��)��
	 * 
	 *	ע�⣺
	 *	�������ṩ��javac������ʹ�õģ��������޶����ϵ��������ͣ��ñ�������Դ���뼶���ϣ�����ס�򼯺��в���Ƿ����ݡ�
	 *	����������������з��ε�java��������ɵ�class�ļ��н����ٴ��з�����Ϣ���Դ�ʹ��������Ч�ʲ��ܵ�Ӱ�죬������̳�֮Ϊ����������
	 *
	 *	���εĻ������
	 *	��ArrayList<E>Ϊ����<>����typeof
	 *	ArrayList<E>�е�E��Ϊ���Ͳ�������
	 *	ArrayList<Integer>�е�Integer��Ϊʵ�����Ͳ���
	 *	������ΪArrayList<E>��������
	 *	����ArrayList<Integer>��Ϊ������������ParameterizedType 

	 */
	public static void main(String[] args)
	{		
	}
	
	//����Ӧ��1
	@Test
	public void test1() 
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int i = list.get(0);
		System.out.println(i+"����תΪint������Ŷ��");
	}
	
	//����Ӧ��2 --����
	@Test
	public void test2() 
	{
		Map<String,Integer> map = new HashMap<String,Integer>();
		map.put("aa", 1);
		map.put("bb", 2);
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		for(Map.Entry<String, Integer> me : set)
		{
			System.out.println(me.getKey() + "=" + me.getValue());
		}
	}
	
	@Test
	public void test3() 
	{
		//List<int> list = new ArrayList<int>();  //�������
	}
	
	//һ���õ��˷��Σ����ߵ����;�Ӧ��һ�£�������ֻ��һ�߾�û����
	@Test
	public void test4() 
	{
		//ArrayList<Integer> list = new ArrayList<Object>();  //Integer pig dog
		//ArrayList<Object> list = new ArrayList<String>(); 

		ArrayList<String> list = new ArrayList ();

		List<Integer> l  = t1();
		List l11 = t2();		
	}
	
	public List t1()
	{
		return new ArrayList();
	}
	
	public List<Integer> t2()
	{
		return new ArrayList<Integer>();
	}	
}
