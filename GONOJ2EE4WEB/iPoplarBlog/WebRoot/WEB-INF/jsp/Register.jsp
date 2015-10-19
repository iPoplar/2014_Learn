<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@table uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>Register Blog</title>  
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/blog.js">
    </script>	
  </head>
  
  <body style="text-align: center;" onload="pageInit()">
  <form action="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post" onsubmit="return dosubmit()" id="userInfo">
			<table>
				<tr>
					<td colspan="2">Poplar Blog</td>
				</tr>

				<tr>
					<td>用户名:</td>
					<td><input type="text" name = "userName"/></td>
				</tr>

				<tr>
					<td>密码:</td>
					<td><input type="password" name = "password" /></td>
				</tr>

				<tr>
					<td>确认密码:</td>
					<td><input type="password" name = "SurePassword" /></td>
				</tr>

				<tr>
					<td>性别:</td>
					<td>
					<input type="radio"  name = "Sex" /> 男
					<input type="radio"  name = "Sex" /> 女
					</td>
				</tr>

				<tr>
					<td>出生日期:</td>
					<td><input type="text" name = "Birthday" /></td>
				</tr>

				<tr>
					<td>个人简介:</td>
					<td><input type="textarea" name = "Introduce" rols = "5"; col ="40"/></td>
				</tr>

				<tr>
					<td colspan="2" style="text-align:right">
						<input type="submit" value="注册" />
						<input type="reset" value="清空">
					</td>
				</tr>
			</table>
		</form>
</body>
</html>
