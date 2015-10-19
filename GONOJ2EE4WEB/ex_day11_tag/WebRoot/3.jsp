<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/bmy.tld" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>if...else标签</title>  	
  </head>
  
  <body>
   	<c:choose>
   		<c:when test="${user!=null}">
   			8888888if
   		</c:when>
   		
   		<c:otherwise>
   			111111111else
   		</c:otherwise>
   	</c:choose>

  </body>
</html>
