<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/bmy.tld" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>转义标签</title>  	
  </head>
  
  <body>
    <a href="">点点</a>
    <c:htmlFilter>
    	<a href="">点点</a>
    </c:htmlFilter>
	
  </body>
</html>
