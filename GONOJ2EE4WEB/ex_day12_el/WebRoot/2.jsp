<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="cn.bmy.test.User"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>el隐式对象&数据回显</title>  	
  </head>
  
  <body>
	${pageContext }<!-- pageContext.findAttribute("name") -->
	
	<br/>
	<br/>---------------从指定的page域中查找数据------------------------<br/>
	<%
		pageContext.setAttribute("name","pageName");	//map
	%>
	${pageScope.name }
	    
<br/>---------------从request域中获取数据------------------------<br/>
	<%
		request.setAttribute("name","requestName");
	%>
	${requestScope.name }
<br/>---------------从session域中获取数据------------------------<br/>
	${sessionScope.user }
	
<br/>--------------获得用于保存请求参数map，并从map中获取数据------------------------<br/>
<!-- http://localhost:8080/day12/3.jsp?name=aaa  -->
	${param.name }
	
<!-- 此表达式会经常用在数据回显上 -->
	<form actioin="${pageContext.request.contextPath }/servlet/RegisterServlet" method="post">
		<input type="text" name="username" value="${param.username }">
		<input type="submit" value="注册">
	</form>
	
<br/>--------------paramValues获得请求参数 //map{"",String[]}------------------------<br/>
<!-- http://localhost:8080/day12/3.jsp?like=aaa&like=bbb -->
	${paramValues.like[0] }
	${paramValues.like[1] }

<br/>--------------header获得请求头------------------------<br/>
	${header.Accept }
	${header["Accept-Encoding"] }
<br/>--------------获取客户机提交的cookie------------------------<br/>
<!-- 从cookie隐式对象中根据名称获取到的是cookie对象,要想获取值，还需要.value -->
	${cookie.JSESSIONID.value }//保持所有cookie的map

<br/>--------------获取web应用初始化参数------------------------<br/>
	${initParam.xxx }
	//servletContext中用于保存初始化参数的map
	${initParam.root }
   	
<br/><br/>---------------使用el函数回显数据（重要！！！）---------------------------<br/>
    
     <% 
    	User user = new User();
    	String likes[] = {"sing","dance"};
    	user.setLikes(likes);
    	
    	//数据回显
    	request.setAttribute("user",user);
    %>
 
    <input type="checkbox" name="like" vlaue="sing" ${fn:contains(fn:join(user.likes,","),"sing")?'checked':'' }>唱歌
     <input type="checkbox" name="like" value="dance"  ${fn:contains(fn:join(user.likes,","),"dance")?'checked':'' }>跳舞
      <input type="checkbox" name="like" value="basketball"  ${fn:contains(fn:join(user.likes,","),"basketball")?'checked':'' }>蓝球
       <input type="checkbox" name="like" value="football"  ${fn:contains(fn:join(user.likes,","),"football")?'checked':'' }>足球
    
    
    ${fn:escapeXml("<a href=''>点点</a>") }
    
    <br/>-----------------------c:out标签--------------------------------------<br/>
  	<% 
  		request.setAttribute("data",null);
  	%>
    <c:out value="${data}" escapeXml="true" default="对不起，您要的数据找不着哟！！！"></c:out>
   
   
   <br/>-----------------------c:set标签:向web存数据，向map或bean中存数据--------------------------------------<br/>
    <c:set var="data" value="xxx" scope="page"/>
    ${pageScope.data }
    <% 
    	Map map = new HashMap();
    	request.setAttribute("map",map);
    %>
    <c:set property="data" value="yyyyy" target="${map}"/>
    ${map.data }
    <%--<c:set property="name" value="flx" target="${person}"></c:set>--%>
    
    
    <br/>-----------------------c:if标签--------------------------------------<br/>
    
    <c:if test="${user==null}" var="b" scope="page"></c:if>
    ${b }
    
    <br/>-----------------------foreach标签--------------------------------------<br/>
    
    <c:forEach var="num" begin="1" end="10" step="1">
    	${num }
    </c:forEach>
    
    <% 
    	List list = Arrays.asList("1","2");
    	request.setAttribute("list",list);
    %>
    
    <c:forEach var="index"  begin="0" end="${fn:length(list)}">
    	${list[index] }
    </c:forEach>
    
    
    <br/>-----------------------c:url标签(重点)--------------------------------------<br/>
    <c:url value="/servlet/ServletDemo1" var="servletdemo1">
    	<c:param name="name" value="中国"/>
    	<c:param name="password" value="我是一个"/>
    </c:url>
    <a href="${servletdemo1 }">点点</a>
    
  </body>
</html>
