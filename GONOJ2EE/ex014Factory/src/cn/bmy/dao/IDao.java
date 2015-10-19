package cn.bmy.dao;

import org.dom4j.DocumentException;
import org.junit.Test;

public interface IDao 
{
	
	public void read() throws DocumentException;

	@Test
	public abstract void find(String emelent) throws DocumentException;

	@Test
	public abstract void findWithXpath() throws DocumentException;

}
