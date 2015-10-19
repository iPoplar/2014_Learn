package junit.test;



import java.util.Date;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

public class Demo
{
	public static void main(String[] args) 
	{
		String birthday = "1994-08-12";
		//TODO ?
		DateLocaleConverter conver = new DateLocaleConverter();
		Date d = (Date) conver.convert(birthday);
		System.out.println(d);
		
	}

}
