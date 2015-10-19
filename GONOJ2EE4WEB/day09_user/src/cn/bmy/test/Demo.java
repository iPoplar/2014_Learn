package cn.bmy.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo 
{
	String birthday = "1980-12sdd-30";
	
	/*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	Date d = sdf.parse(birthday);
	
	System.out.println(d);	*/				
		
	
	DateLocaleConverter conver = new DateLocaleConverter();
	Date d = (Date) conver.convert(birthday);
//	System.out.println(d);
}
