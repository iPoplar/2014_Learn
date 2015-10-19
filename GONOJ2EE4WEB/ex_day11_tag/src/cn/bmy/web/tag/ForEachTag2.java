package cn.bmy.web.tag;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ForEachTag2 extends SimpleTagSupport
{
	private Object items;
	private String var;
	private Collection collection;
	
	public void setItems(Object items)
	{
		this.items = items;
		
		if(items instanceof Collection)
		{
			collection = (Collection) items;//listset
		}
		
		if(items instanceof Map)
		{
			Map map = (Map)items;
			collection = map.entrySet();
		}
		//反射
		if(items.getClass().isArray())
		{
			//int[] byte[] String[]
			collection = new ArrayList();
			int len = Array.getLength(items);
			for(int i=0; i<len; i++)
			{
				Object obj = Array.get(items, i);
				collection.add(obj);
			}
			
		}
		/*sun公司的传统做法
		 * if(items instanceof Object[]){
		Object arg[] = (Object[]) items;
		collection = Arrays.asList(arg);  //list
	}
	
	if(items instanceof int[]){
		int temp[] = (int[])items;
		collection = new ArrayList();
		for(int num : temp){
			collection.add(num);
		}
	}
	
	if(items instanceof short[]){
		
	}
	
	if(items instanceof byte[]){
		
	}*/
			
	}
	//<c:foreach-->java类
	public void setVar(String var)
	{
		this.var = var;
	}
	
	@Override
	public void doTag() throws JspException, IOException 
	{
		PageContext pageContext = (PageContext) this.getJspContext();
		Iterator it = collection.iterator();
		
		while(it.hasNext())
		{
			Object obj = it.next();
			pageContext.setAttribute(var, obj);
			this.getJspBody().invoke(null);
		}
	}
	
	
}
