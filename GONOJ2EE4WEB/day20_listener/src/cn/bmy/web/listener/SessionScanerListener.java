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
 * 自定义session扫描器
 *
 */
public class SessionScanerListener implements HttpSessionListener,
		ServletContextListener {
	//特殊对象是考虑到线程安全的问题
	//在这里只能选择context域将时间信息带过去
	private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
	private Object lock;
	
	public void sessionCreated(HttpSessionEvent se) {
		HttpSession session = se.getSession();
		synchronized(lock)			//为了解决分隔开的代码的同步代码块的问题，使用了锁旗标lock；
		{							//并且两处的代码都使用上同步代码块synchronization。
			list.add(session);		//以解决高并发问题
		}

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("session被销毁了！！");

	}

	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub

	}

	public void contextInitialized(ServletContextEvent sce) {
		Timer timer = new Timer();
		timer.schedule(new MyTask(list,lock), 0, 1000*15);

	}

}
//定时器
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
		synchronized (lock)	//被锁旗标限制的同步代码块
		{
			System.out.println("定时器执行！！！");
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
