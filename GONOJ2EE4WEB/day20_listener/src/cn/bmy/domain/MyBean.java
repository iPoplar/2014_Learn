package cn.bmy.domain;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

public class MyBean implements HttpSessionActivationListener {
	/**
	 * ��session�Լ��ļ���
	 * ������ͳ�� ��ҳ�ķ���������
	 */
	//Ҳ��֮Ϊ�
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("session��Ӳ�̻ص��ڴ���");

	}

	//Ҳ��֮Ϊ�ۻ�
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("session�����л���Ӳ����");

	}

}
