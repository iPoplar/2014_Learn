<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bmy.base.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>el表达式运算符</title>  	
  </head>
  
  <body>
   ${365*24 }
   ${user==null }
   
   <br/>
   <%
   	List list = null;
   	request.setAttribute("list",list);
   %>
   
   <c:if test="${!empty(list)}">
   		<c:forEach var="str" items="${list}">
   			${str }
   		</c:forEach>
   </c:if>
   
   <c:if test="${empty(list)}">
   		对不起，没有您想要看的数据！
   </c:if>
   
   <br/>
   
   <%
   		session.setAttribute("user", new User("xiaobai"));
   %>
   ${user==null?"Sorry ,you not landing!!" : user.username }
   
    <br/>
    
    <%
    	User user = new User();
    	user.setGender("male");
    	
    	//数据回显
    	request.setAttribute("user", user);
      %>
      
      <input type="radio" name="gender" value="male" ${user.gender=='male'?'checked':'' }>man
      <input type="radio" name="gender" value="female" ${user.gender=='female'?'checked':'' }>femal
      
      <br/>
      <%
      		user = new User();
      		String likes[] = {"sing","dance", "basketball"};
      		user.setLikes(likes);
      		
      	//数据回显
      	request.setAttribute("user",user);
      %>
      
      <input type="checkbox" name="like" value="sing">sing
      
      
  </body>
</html>
