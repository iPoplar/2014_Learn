package cn.bmy.demo;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class demo1 
{
	/**
	 * ������java���¼���������
	 * 1.�¼������漰������������¼�Դ���¼������¼�������
	 * 2.���¼�Դ�Ϸ���ĳһ������ʱ����������¼���������һ��������
	 * ���ڵ��ø÷���ʱ���¼����󴫵ݽ�ȥ��������Ա�ڼ�������ͨ���¼�����
	 * �Ϳ����õ��¼�Դ���Ӷ����¼����в���
	 */
	public static void main(String[] args) 
	{
		Frame f = new Frame();
		f.setSize(400, 400);
		f.setVisible(true);
		
		f.addWindowListener(new WindowListener()
		{

			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowClosing(WindowEvent e) 
			{
				System.out.println("ŷ��£�this is windowClosing!");
				Frame f = (Frame) e.getSource();//�ô����¼����¼�Դ
				f.dispose();//�����¼�Դ
				
				
			}

			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
	}

}
