package test;

import java.lang.reflect.Field;

import org.junit.Test;

import cn.bmy.utils.XmlUtils2l;

public class test2
{
	@Test
	public void collect() throws ClassNotFoundException, IllegalArgumentException, IllegalAccessException
	{
		XmlUtils2l path = new XmlUtils2l();
		Class clazz = Class.forName("cn.bmy.utils.XmlUtils2l");		
		
		Field[] field = clazz.getDeclaredFields();
		for(Field f : field)
		{
			f.setAccessible(true);
			f.set(path, "xslfjdslfjlsd");
			System.out.println(f+"@@@");
			f.setAccessible(false);
		}		
	}

}
