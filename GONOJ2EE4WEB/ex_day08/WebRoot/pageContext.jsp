<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>pageContext访问其他域</title>  	
  </head>
  
  <body>
    <%
    	//相当于向session域中存入了一个数据
    	pageContext.setAttribute("data","xxx",PageContext.SESSION_SCOPE);
    
    	//从session域中取到数据的几种方式
    	//String data = (String)session.getAttribute("data");
    	//String data =(String)pageContext.getAttribute("data",PageContext.SESSION_SCOPE);
    	String data = (String)pageContext.findAttribute("data");
    	//findAttribute的运行原理：一次从如下4个域中去查找
    	//pageContext  request session  servletContext
    	
    %>
    <!-- 向浏览器输出有两种方式 -->
    <!-- out.write();		 -->
    <%=data %>
    
  </body>
</html>
