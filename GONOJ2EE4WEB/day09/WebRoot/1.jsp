<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bmy.Person" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>jsp:usebean标签</title>  	
  </head>
  
  <body>
    <%
    	pageContext.setAttribute("person",new Person());
     %>
     <!-- class属性必须指定bean的完整类名 -->
     <!-- 标签体内容只在实例化bean时执行 -->
     <jsp:useBean id="person" class="cn.bmy.Person" scope="page">
     XXXXXXxxxxxxx
     </jsp:useBean>
     
     <%
     	System.out.println(person.getName());
      %>
  </body>
</html>
