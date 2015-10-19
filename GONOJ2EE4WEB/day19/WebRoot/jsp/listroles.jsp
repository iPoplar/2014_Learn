<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列出所有角色</title>
  </head>
  
 <body style="text-align: center;">
	
	<br/>
	
	<table width="70%">
		<tr>
			<td  align="right">
				<a href="${pageContext.request.contextPath }/jsp/addrole.jsp">添加角色</a>
			</td>
		</tr>
	</table>
	
	<table frame="border" width="70%">
		<tr>
			<td>角色名称</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="role" items="${roles}">
			<tr>
				<td>${role.name }</td>
				<td>${role.description }</td>
				<td>
					<a href="${pageContext.request.contextPath }/servlet/AddRolePrivilegeUIServlet?role_id=${role.id }">为角色授权</a>
					<a href="#">修改角色</a>
					<a href="#">删除角色</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>

  </body>
</html>
