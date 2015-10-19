<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>添加权限</title>
  </head>
  
  <body>
	
	<form action="${pageContext.request.contextPath }/servlet/AddPrivilegeServlet" method="post">
		权限名称：<input type="text" name="name"><br/>
		权限描述：<textarea rows="5" cols="30" name="description"></textarea><br/>
		<input type="submit" value="添加权限">
	</form>
	
  </body>
</html>
