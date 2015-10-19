<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>pageContext访问其他域</title>  	
  </head>
  
  <body>
	<%
		pageContext.setAttribute("data","xxx2",PageContext.SESSION_SCOPE);
		//String data = (String)session.getAttribute("data");
		//String data = (String)pageContext.getAttribute("data",PageContext.SESSION_SCOPE);
		String data = (String)pageContext.findAttribute("data");
				
	 %>
	 
	 <%=data %>>
  </body>
</html>
