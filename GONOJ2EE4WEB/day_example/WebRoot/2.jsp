<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/bmy" prefix="c" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>c:if标签</title>  	
  </head>
  
  <body>
    
    <c:if test="${user==null }">
    ComeOn,Baby!
    </c:if>
    
  </body>
</html>
