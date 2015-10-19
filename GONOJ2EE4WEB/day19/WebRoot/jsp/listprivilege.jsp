<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>列出网站所有权限</title>
  </head>
  
  <body style="text-align: center;">
	
	<br/>
	
	<table width="50%">
		<tr>
			<td  align="right">
				<a href="${pageContext.request.contextPath }/jsp/addprivilege.jsp">添加权限</a>
			</td>
		</tr>
	</table>
	
	<table frame="border" width="50%">
		<tr>
			<td>权限名称</td>
			<td>描述</td>
			<td>操作</td>
		</tr>
		
		<c:forEach var="p" items="${privileges}">
			<tr>
				<td>${p.name }</td>
				<td>${p.description }</td>
				<td>
					<a href="#">修改权限</a>
					<a href="#">删除权限</a>
				</td>
			</tr>
		</c:forEach>
		
	</table>

  </body>
</html>
