<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>显示所有用户</title>
  </head>
  
  <body style="text-align: center;">
 
 	<c:choose>
 	<c:when test="${!empty(list)}">
    <table width="90%" frame="border">
    	<tr>
    		<td>客户姓名</td>
    		<td>性别</td>
    		<td>生日</td>
    		<td>手机号码</td>
    		<td>邮箱</td>
    		<td>爱好</td>
    		<td>类型</td>
    		<td>备注</td>
    		<td>操作</td>
    	</tr>
    	
    	<c:forEach var="c" items="${list}">
    		<tr>
	    		<td>${c.name }</td>
	    		<td>${c.gender }</td>
	    		<td>${c.birthday }</td>
	    		<td>${c.cellphone }</td>
	    		<td>${c.email }</td>
	    		<td>${c.preference }</td>
	    		<td>${c.type }</td>
	    		<td>${c.description }</td>
	    		<td>
	    			<a href="#">修改</a>
	    			<a href="#">删除</a>
	    		</td>
    		</tr>
    	</c:forEach>
    
    </table>
    </c:when>
    
    <c:otherwise>
    	对不起，系统还没有任何客户信息！！
    </c:otherwise>
    
    </c:choose>
    
  </body>
</html>
