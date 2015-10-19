<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加用户</title>
  </head>
  
  <body>
    <form action="${pageContext.request.contextPath }/servlet/AddUserServlet" method="post">
		用户名称：<input type="text" name="username"><br/>
		用户密码：<input type="text" name="password"><br/>
		<input type="submit" value="添加用户">
	</form>
  </body>
</html>
