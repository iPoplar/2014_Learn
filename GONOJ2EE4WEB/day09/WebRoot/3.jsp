<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bmy.Person"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>el表达式</title>  	
  </head>
  
  <body>
  	<%
  		request.setAttribute("name","aaa");
  	%>
  	<!-- pageContext.findAttribute("name") 从page request session application 域中查找-->
  	${name }
  	
  	<!-- 在jsp页面中，使用el表达式可以获取bean的属性 -->
  	<%
  		Person p = new Person();
  		p.setAge(12);
  		request.setAttribute("person",p); 	
  	%>
  	${person.age }
  	
  	<!-- 在jsp页面中，使用el表达式获取list集合中指定位置的数据 -->
  	<%
  		Person p1 = new Person();
  		p1.setName("bmdysdf");
  		
  		Person p2 = new Person();
  		p2.setName("bss");
  		
  		List list = new ArrayList();
  		list.add(p1);
  		list.add(p2);
  		
  		request.setAttribute("list", list);
  	%>
  		${list[0].name }
  		
  	<!-- 在jsp页面中，使用el表达式获取map集合的数据 -->
  	<%
  		Map map = new HashMap();
  		map.put("a","aaaxxx");
  		map.put("b","bbbb");
    	map.put("c","cccc");
    	
    	map.put("1","aaaa1111");
    	
  		request.setAttribute("map",map);
  	%>
  	${map.a }
  	${map["1"] }
  	
  	<!-- 利用el表达式获取web应用的名称 -->
  	<a href="${pageContext.request.contextPath }/1.jsp">O(∩_∩)O~</a>
  	
  	<!-- 注意：如果访问bean不存在的属性，会抛出Property 'username' not found on type cn.bmy.Person  -->
  	<%-- ${person.username --%>
  </body>
</html>
