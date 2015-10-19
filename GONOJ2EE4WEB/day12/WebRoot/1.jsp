<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="cn.bmy.base.Person"%>
<%@page import="cn.bmy.base.Address"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>el表达式获取数据示例</title>  	
  </head>
  
  <body>
  <%
  	request.setAttribute("name","xiao");
  %>
  
  ${name } <%-- pageContext.findAttribute("name") --%>
  
  <br/><br/><br/>
  <!-- 在jsp页面中，使用el表达式可以获取bean的属性 -->
  <%
  	Person p = new Person();
  	p.setAge(20);
  	request.setAttribute("person",p);  	
  %>
  
  ${person.age }
  
   <br/><hr><br/>
    <!-- 在jsp页面中，使用el表达式可以获取bean中的。。。。。。。。。的属性 -->
    <%
    	Person person = new Person();
    	Address address = new Address();
    	person.setAddress(address);
    	
    	request.setAttribute("person",person);
    %>
    ${person.address.name }
    
     <br/><hr><br/>
    <!-- 在jsp页面中，使用el表达式获取list集合中指定位置的数据 -->
    <%
    	Person p1 = new Person();
    	p1.setName("(ˇˍˇ） 想～这是p1的name");
    	
    	Person p2 = new Person();
    	p2.setName("(*^__^*) 嘻嘻……这是p2的name");
    	
    	List list = new ArrayList();
    	list.add(p1);
    	list.add(p2);
    	
    	request.setAttribute("list",list);   	
    	
    %>
   	取list指定位置的数据
    ${list[1].name }<!-- 取list指定位置的数据 -->
    ${list[2].name }
    
    <br/><hr><br/>
    <!-- 迭代集合 -->
     迭代集合
    <c:forEach var = "person" items="${list }">
    	${person.name }
    </c:forEach>
    
     <br/><hr><br/>
    <!-- 在jsp页面中，使用el表达式获取map集合的数据 -->
    <%
    	Map map = new HashMap();
    	map.put("A","aaa");
    	map.put("B","bbb");
    	map.put("C","ccc");
    	map.put("1","123");
    	
    	request.setAttribute("map",map);
    %>
    <!-- 根据关键字取map集合的数据 -->
    ${map.C }
    ${map["1"] }
     <br/><hr>这是forEach<br/>
     
   	 <c:forEach var="me" items="${map }">
    	${me.key } = ${me.value } <br/>
    </c:forEach>
     
  </body>
</html>
