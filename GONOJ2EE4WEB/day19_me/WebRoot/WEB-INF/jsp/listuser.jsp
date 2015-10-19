<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>列出网站所有用户</title>  	
  </head>
  
  <body style="text-align: center;">
	
	<br/>
	
	<table width="70%">
		<tr>
			<td  align="right">
				<a href="${pageContext.request.contextPath }/jsp/adduser.jsp">添加用户</a>
			</td>
		</tr>
	</table>
	
	<table frame="border" width="70%">
		<tr>
			<td>用户名称</td>
			<td>用户密码</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="user" items="${users}">
			<tr>
				<td>${user.username }</td>
				<td>${user.password }</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/AddUserRoleUIServlet?user_id=${user.id }">为用户授权角色</a>
					<a href="#">修改用户</a>
					<a href="#">删除用户</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>

  </body>
</html>
