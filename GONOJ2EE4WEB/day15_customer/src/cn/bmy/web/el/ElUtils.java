package cn.bmy.web.el;

public class ElUtils 
{
	public static String subString (String source ,Integer length)
	{
		if(source.length()>length)
			return source.substring(0,length)+".....";
		return source;
	}

}
