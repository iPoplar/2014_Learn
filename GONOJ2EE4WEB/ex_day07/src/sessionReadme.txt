要是浏览器关掉后，在下次访问时依然可以拿到之前的session: ----手工的回送cookie
		通过session拿到访问的id，然后new 一个cookie，覆盖浏览器的cookie，
		设置其有效期,回送给浏览器
		
		String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID",sessionid);
		cookie.setMaxAge(1*3600);
		cookie.setPath("/ex_day07");
		
		response.addCookie(cookie);

==============================
服务器默认的配置：
	当第一次session被get的时候，才会被创建；
	当浏览器窗口被关闭的30分钟后，session才会被摧毁；
	
==============================
当浏览器禁用cookie后，session的处理问题-----URL重写
	当使用URL重写解决时，网站上的所有地址都得进行URL重写
	