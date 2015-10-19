<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/bmy" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>if...else标签</title>  	
  </head>
  
  <body>
    
	<c:choose>
		<c:when test="${user!=null }">
		~\(≧▽≦)/~啦啦啦
		</c:when>
		
		<c:otherwise>
		ss	O(∩_∩)O~
		</c:otherwise>
	</c:choose>

  </body>
</html>
