package cn.bmy.web.listener;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * �Զ���sessionɨ����
 *
 */
public class SessionScanerListener implements HttpSessionListener,
		ServletContextListener {
	//��������ǿ��ǵ��̰߳�ȫ������
	//������ֻ��ѡ��context��ʱ����Ϣ����ȥ
	private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock;
	
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		synchronized(lock)			//Ϊ�˽���ָ����Ĵ����ͬ�����������⣬ʹ���������lock��
		{							//���������Ĵ��붼ʹ����ͬ�������synchronization��
			list.add(session);		//�Խ���߲�������
		}

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session�������ˣ���");

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent sce) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(list,lock), 0, 1000*15);

	}

}
//��ʱ��
class MyTask extends TimerTask
{
	private List<HttpSession>list;
	private Object lock;
	public MyTask(List list,Object lock)
	{
		this.list = list;
		this.lock = lock;
	}
	@Override
	public void run()
	{
		synchronized (lock)	//����������Ƶ�ͬ�������
		{
			System.out.println("��ʱ��ִ�У�����");
			ListIterator<HttpSession> it = list.listIterator();
			while(it.hasNext())
			{
				HttpSession session  = (HttpSession)it.next();
				if(System.currentTimeMillis()-session.getLastAccessedTime()>1000*15)
				{
					session.invalidate();
					it.remove();
				}
			}
			
		}
		
	}
}
