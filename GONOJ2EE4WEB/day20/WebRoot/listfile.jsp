<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>My JSP 'listfile.jsp' starting page</title>  	
  </head>
  
  <body>
  <!-- //因为从forEach标签库下的${me.value} 下取出的值有可能是中文等，
  	所有不能直接链接到PageCotext域下，获取想要的值，SO：使用标签<c:url> -->
   <c:forEach var="me" items="${map}">
    	<c:url value="/servlet/DownLoadServlet" var="downurl">
    		<c:param name="filename" value="${me.key}"></c:param>
    	</c:url>
    	${me.value }  <a href="${downurl}">下载</a>  <br/>
    </c:forEach>
    
  </body>
</html>
