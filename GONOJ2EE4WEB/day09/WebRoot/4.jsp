<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bmy.Person"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>jstl+el表达式示例代码</title>  	
  </head>
  
  <body>
  	 <!-- 使用jstl+el表达式可以迭代list集合 -->
  	 <%
  	 	Person p1 = new Person();
  	 	p1.setName("aaa111");
  	 	
  	 	Person p2 = new Person();
  	 	p2.setName("bb");
  	 	
  	 	List list = new ArrayList();
  	 	list.add(p1);
  	 	list.add(p2);
  	 	
  	 	request.setAttribute("list",list);
  	 %>
  	
  	<c:forEach var="person" items="${list }">
  	${person.name }<br/>
  	</c:forEach>
  	
  	 <!-- 使用jstl+el表达式可以迭代map集合 -->
  	 <%
  	 	Map map = new HashMap();
  	 	map.put("a","aaaxxx");
    	map.put("b","bbbb");
    	map.put("c","cccc");
    	map.put("1","aaaa1111");
    	
    	request.setAttribute("map",map);
   	 %>
   	 
   	 <br/>
   	 <%-- Set<Map.Entry> set = map.entrySet()--%>
   	 <c:forEach var="me" items="${map}">
   	 ${me.key } = ${me.value }<br/>
   	 </c:forEach>
   	 
   	  <br/><br/>
   	  
   	  <c:if test="${user!=null}">
   	  欢迎您：${user.username }
   	  </c:if>
   	  
   	  <c:if test="${user==null }">
   	  用户名:<input type="text" name="username">
   	  密码：<input type="password" name="password">
   	  </c:if>
  </body>
</html>
