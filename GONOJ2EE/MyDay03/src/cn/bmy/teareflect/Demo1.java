package cn.bmy.teareflect;

public class Demo1 {

	/**
	 *加载类的字节码
	 */
	public static void main(String[] args) throws Exception {
		
		//1.
		Class clazz1 = Class.forName("cn.itcast.reflect.Person");
		
		//2
		Class clazz2 = Person.class;
		
		//3
		//Class clazz3 = new Person().getClass();
		
		Person p = (Person) clazz1.newInstance();
	}

}
