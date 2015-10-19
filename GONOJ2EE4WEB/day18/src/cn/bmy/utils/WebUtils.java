package cn.bmy.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class WebUtils
{
	public static String md5(String message)
	{
		try 
		{
			MessageDigest md = MessageDigest.getInstance("md5");
			byte result[] = md.digest(message.getBytes());
		
			BASE64Encoder encoder = new BASE64Encoder();
			return encoder.encode(result);
		} catch (NoSuchAlgorithmException e) 
		{
			throw new RuntimeException(e);
		}
	}

}
