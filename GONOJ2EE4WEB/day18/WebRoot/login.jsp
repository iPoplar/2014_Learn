<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>My JSP 'login.jsp' starting page</title>  	
  </head>
  
  <body>
   
   <form action="${pageContext.request.contextpath }/servlet/LoginServlet" method="post">
   	用户名：<input type="text" name="username"><br/>
   	密码：<input type="password" name="password"><br/>
   	有效期:
   		<input type="radio" name="logintime" value="3600">小时
   		<input type="radio" name="logintime" value="${10*60 }">10分钟
   		<input type="radio" name="logintime" value="${5*60 }">5分钟
   		<br/>
   		
   		<input type="submit" value="登录">
   </form>
   
  </body>
</html>
