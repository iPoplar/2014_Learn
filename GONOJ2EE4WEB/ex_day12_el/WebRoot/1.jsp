<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="cn.bmy.test.Person" %>
<%@page import="cn.bmy.test.Address"%>
<%@page import="cn.bmy.test.User" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>el表达式获取数据示例&数据回显</title>  	
  </head>
  
  <body>
	<%
		request.setAttribute("name","aaaa");
	%>    
	
	${name }<%-- pageContext.findAttribute("name")--%>
	<br/><hr><br/>
	<!-- 在jsp页面中，使用el表达式可以获取bean中的。。。。属性 -->
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
		p1.setName("personName1");
		
		Person p2 = new Person();
		p2.setName("persnName2");
		
		List list = new ArrayList();
		list.add(p1);
		list.add(p2);
		
		request.setAttribute("list",list);
	%>
	${list[1].name }<!-- 取list指定位置的数据 -->
	
	<!-- 迭代集合 -->
	<c:forEach var="person" items="${list}">
		${person.name }
	</c:forEach>
	<br/><hr><br/>
	<!-- 在jsp页面中，使用el表达式获取map集合的数据 -->
	<%
		Map map = new HashMap();
		map.put("b","bbbb");
		map.put("c","cccc");
		map.put("1","aaaa1111");
		request.setAttribute("map",map);
	%>
	${map.c }<!-- 根据关键字取map集合的数据 -->
	${map["1"] }
	
	<c:forEach var="me" items="${map}">
		${me.key } = ${me.value }<br/>
	</c:forEach>
<br/>==========================================<br/>
<!--
	empty()方法可以很方便的对集合中的数据进行判空
	eg：
		<c:if test="${!empty(list)}" >
			<c:forEach var="str" items="${list}">
				${str}
			</c:forEach>
		</c:if>
		
		<c:if test="${empty(list)}">
			对不起，没有您想看到的数据
		</c:if>				
 -->
 <br/>==========================================<br/>
 <%
 	User user = new User();
 	user.setGender("male");
 	
 	//数据回显
 	request.setAttribute("user",user);
 %>
	<input type="radio" name="gender" value="male" ${user.gender=='male'?'checked':'' }>男
<input type="radio" name="gender" value="female" ${user.gender=='female'?'checked':'' }>女
  </body>
</html>
