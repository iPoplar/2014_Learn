package test;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {

	/**
	 * @param args
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException
	{
//		Map<String, Book> map = new HashMap<String, Book>();
//		Book b1 = new Book();
//		Book b2 = new Book();
//		b1.setName("1");
//		b2.setName("2");
//		
//		map.put("a", b1);
//		map.put("b", b2);
//		
//		b1.setName("11111");
//		b2.setName("22222");
//		
//		for(Map.Entry<String, Book> s : map.entrySet())
//		{
//			System.out.println(s.getKey());
//			System.out.println(s.getValue().getName());
//		}
		/*
		List<String> l = new ArrayList<String>();
		
		for(String i : l)
		{
			
		} */
		
//		Map<String, HashMap<String, String>> test = new HashMap<String, HashMap<String, String>>();
//		HashMap<String, String> map1 = new HashMap<String, String>();
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		HashMap<String, String> map3 = new HashMap<String, String>();
//		map1.put("a", "aaaaaaaa");
//		map2.put("b", "bbbbbbbb");
//		map3.put("c", "cccccccc");
//		test.put("a__test", map1);
//		test.put("b__test", map2);
//		test.put("c__test", map3);
//		for(Map.Entry<String, Book> s : map.entrySet())
//		{
//			System.out.println(s.getKey());
//			System.out.println(s.getValue().getName());
//		}
		
//		for(Map.Entry<String, HashMap<String, String>> s : test.entrySet())
//			for(Map.Entry<String, String> d : s.getValue().entrySet())
//			{
//				System.out.println(d.getKey());
//				System.out.println(d.getValue());
//			}
		
		Book b = new Book();
		
		Class c = b.getClass();
		System.out.println(c);
		Field[] field = c.getDeclaredFields();
		for(Field f : field)
		{
			f.setAccessible(true);
			f.set(b, "123");
			f.setAccessible(false);
		}
		
		System.out.println(b.getName());
	}
	
	private static class Book
	{
		private String name;
		
		private String password;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	}

}
