<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>struts的路径问题</title>
	<%
		String path = request.getContextPath();
		String basePath = request.getScheme()+ "://" + request.getServerName()+":" + request.getServerPort()+path+"/";
	%>
  </head>
  
  <body>
    	struts2的路径问题是根据action的路径而不是jsp的路径来确定的，所以尽量不要使用相对路径    	
    	<base href="<%=basePath%>" />
    	<a href="index.jsp">index.jsp</a>
    	
    	解决办法是统一使用绝对路径。（在jsp中用request.getContextRoot方式来拿到webapp的路径）
    	或者使用myeclipse经常使用的，指定的basePath
  </body>
</html>
