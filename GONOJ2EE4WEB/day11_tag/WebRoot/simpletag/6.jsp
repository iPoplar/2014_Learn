<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/simplebmy" prefix="bmy" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
  <head>
    <title>如果标签接收的是一个复杂类型，如果给其赋值</title>
  </head>
  
  <body>
  
  <% 
  	Date d = new Date();
  	request.setAttribute("date",d);
  %>
  
   <bmy:demo6 date="${date}">
  </bmy:demo6>
  
  <bmy:demo6 date="<%=new Date() %>">
  </bmy:demo6>
 	
  </body>
</html>
