<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bmy.login.User"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'index.jsp' starting page</title>
	
  </head>
  
  <body>
   欢迎您：
   <%
  	 User user = (User)session.getAttribute("user");
   	out.write(user.getUsername());
   %>
   <br/><br/>
   <a href="/ex_day07/login.html">登陆</a> 
  </body>
</html>
