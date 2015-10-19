<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>cookie的使用练习</title>  	
  </head>
  
  <body>
    <!-- cookie的创建 -->
    <%
    	//创建cookie对象，cookie类的构造方法需要两个参数，一个参数为cookie的名称，一个参数为cookie的值。
    	Cookie cookie = new Cookie("UserName","Poplar");
    	//设置cookie的存活时间，单位是秒
    	cookie.setMaxAge(60*10);
    	//将cookie发送给客户端
    	response.addCookie(cookie);
    	
    %>
    <!-- 读取cookie -->
 	<%
 		Cookie[] cookies = request.getCookies();
 		if(cookies != null)
 		{
 			for(int i=0; i<cookies.length; i++)
 			{
 				Cookie cookie2 = cookies[i];
 				if("UserName".equals(cookie.getName()))
 				{
 					out.print(cookie.getValue());
 					break;
 				}
 				
 			}
 		}
 	%>   
  </body>
</html>
