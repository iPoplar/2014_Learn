package cn.factory;

import java.io.Serializable;

//Serializableд�뵽Ӳ�̱���ʵ�ֵĽӿڣ�����
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
