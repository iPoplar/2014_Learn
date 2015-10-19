<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'addrole.jsp' starting page</title>
  </head>
  
  <body>
   	<form action="${pageContext.request.contextPath }/servlet/AddRoleServlet" method="post">
		角色名称：<input type="text" name="name"><br/>
		角色描述：<textarea rows="5" cols="30" name="description"></textarea><br/>
		<input type="submit" value="添加角色">
	</form>
  </body>
</html>
