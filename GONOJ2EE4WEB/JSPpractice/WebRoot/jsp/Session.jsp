<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>Session的使用练习</title>  	
  </head>
  
  <body>
    <%
    	String sessionId = session.getId();
    	if(session.isNew())
    	{
    		out.print("这是一个新的Session");
    	}
    	else{
    		out.print("这是一个老的session");
    	}
    	//获得session创建的时间
    	Date create = new Date(session.getCreationTime());
    	//获得客户端最后一次请求服务器的时间
    	Date lastAccessDate = new Date(session.getLastAccessedTime());
    	
    	
    %>
  </body>
</html>
