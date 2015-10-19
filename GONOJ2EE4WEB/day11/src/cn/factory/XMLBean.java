package cn.factory;

import java.io.Serializable;

//Serializable写入到硬盘必须实现的接口！！！
public class XMLBean implements Serializable
{
	private String id;
	private String clazz;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
}
