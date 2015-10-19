package cn.bmy.demo;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class demo1 
{
	/**
	 * 请描述java的事件监听机制
	 * 1.事件监听涉及到三个组件：事件源、事件对象、事件监听器
	 * 2.当事件源上发生某一个动作时，它会调用事件监听器的一个方法，
	 * 并在调用该方法时把事件对象传递进去，开发人员在监听器中通过事件对象，
	 * 就可以拿到事件源，从而对事件进行操作
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
				System.out.println("欧麦嘎，this is windowClosing!");
				Frame f = (Frame) e.getSource();//得窗口事件的事件源
				f.dispose();//销毁事件源
				
				
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
