package cn.bmy.generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class Demo1 {

	/**JDK5以前，对象保存到集合中就会失去其特性，取出时通常要程序员手工进行类型的强制转换，
	 * 这样不可避免就会引发程序的一些安全性问题。——>泛型的作用就显现啦！
	 * 
	 * JDK5中的泛形允许程序员在编写集合代码时，就限制集合的处理类型，从而把原来程序运行时可能发生问题，
	 * 转变为编译时的问题，以此提高程序的可读性和稳定性(尤其在大型程序中更为突出)。
	 * 
	 *	注意：
	 *	泛型是提供给javac编译器使用的，它用于限定集合的输入类型，让编译器在源代码级别上，即挡住向集合中插入非法数据。
	 *	但编译器编译完带有泛形的java程序后，生成的class文件中将不再带有泛形信息，以此使程序运行效率不受到影响，这个过程称之为“擦除”。
	 *
	 *	泛形的基本术语，
	 *	以ArrayList<E>为例：<>念着typeof
	 *	ArrayList<E>中的E称为类型参数变量
	 *	ArrayList<Integer>中的Integer称为实际类型参数
	 *	整个称为ArrayList<E>泛型类型
	 *	整个ArrayList<Integer>称为参数化的类型ParameterizedType 

	 */
	public static void main(String[] args)
	{		
	}
	
	//典型应用1
	@Test
	public void test1() 
	{
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		
		int i = list.get(0);
		System.out.println(i+"这是转为int类型了哦！");
	}
	
	//典型应用2 --练练
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
		//List<int> list = new ArrayList<int>();  //错误代码
	}
	
	//一旦用到了泛形，两边的类型就应该一致，或两边只用一边就没问题
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
