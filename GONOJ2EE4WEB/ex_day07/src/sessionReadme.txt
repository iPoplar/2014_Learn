Ҫ��������ص������´η���ʱ��Ȼ�����õ�֮ǰ��session: ----�ֹ��Ļ���cookie
		ͨ��session�õ����ʵ�id��Ȼ��new һ��cookie�������������cookie��
		��������Ч��,���͸������
		
		String sessionid = session.getId();
		Cookie cookie = new Cookie("JSESSIONID",sessionid);
		cookie.setMaxAge(1*3600);
		cookie.setPath("/ex_day07");
		
		response.addCookie(cookie);

==============================
������Ĭ�ϵ����ã�
	����һ��session��get��ʱ�򣬲Żᱻ������
	����������ڱ��رյ�30���Ӻ�session�Żᱻ�ݻ٣�
	
==============================
�����������cookie��session�Ĵ�������-----URL��д
	��ʹ��URL��д���ʱ����վ�ϵ����е�ַ���ý���URL��д
	