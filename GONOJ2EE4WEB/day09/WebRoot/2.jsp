<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>jsp:setProperty getProperty标签的使用</title>  	
  </head>
  
  <body>
  	<!-- JSP：setProperty标签在工作时，他会自动把字符串转成八种基本数据类型 -->
  	<!-- 但是jsp:setProperty标签对于复杂类型无法自动进行转换 -->
  	<jsp:useBean id="person" class="cn.bmy.Person" scope="page"></jsp:useBean>
	 <jsp:setProperty name= "person" property="name" value="aaaaa"/>
	 <jsp:setProperty name="person" property="password" value="123"/>
	 <jsp:setProperty name="person" property="age" value="12"/> 
	 <jsp:setProperty name="person" property="birthday" value="<%=new Date() %>"/>
	 
	 <!-- jsp:setProperty 标签可以使用请求参数为bean的属性赋值 -->
	  <jsp:setProperty name="person" property="name" param="name"/>
	  
	  <!-- jsp:setProperty 标签用所有的请求参数为bean的属性赋值 -->
	   <!-- http://localhost:8080/day09/2.jsp?name=flx&password=123&age=34 -->
	   <jsp:setProperty name="person" property="*"/>
	  ComeOn！Baby！
	 <% 
    	System.out.println(person.getName());
    	System.out.println(person.getPassword());
    	System.out.println(person.getAge());
    %>
     <jsp:getProperty name="person" property="name"/>
    
  </body>
</html>
