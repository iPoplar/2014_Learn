package cn.bmy.domain;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class MyBean2 implements HttpSessionBindingListener {

	//���ּ����������Լ������Լ�
	//���ڳ�����eg��ĳ��̳�����ߵ���ʾ
	private String name;
	
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("�Լ����ӵ�session����");

	}

	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("�Լ���session�߳�����");

	}

}
