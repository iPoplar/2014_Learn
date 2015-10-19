<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>jsp内置对象的练习</title>  
    <!--	存储范围
    	pageContext 在本jsp页面中
    	request 	在一次请求和一次响应之间
    	session 	在一个访问的会话中
    	application 在web应用程序运行期间
    	 
     -->
     
     <!--	include 使用示例
     	<%@ include file="date.jsp"%>      
      -->	
      
      <!--	请求跳转
      		RequestDispatcher rd = request.getRequestDispatcher("页面路径");
      		rd.forward();
      		请求重定向
      		response.sendRedirect("页面URL"); 
      		
      		<jsp:forward>也可以实现请求转发
      		<jsp:forward page="suc.jsp"></jsp:forward> //跳转到suc.jsp页面上
       -->
  </head>
  
  <body>
  	<!-- application -->
  	<%
  		//获得当前请求的应用程序在服务器中存放的文件路径
  		String path = application.getRealPath("");
  	//
  		application.setAttribute("age","18");
  		String age = (String)application.getAttribute("age");
  		application.removeAttribute("age");
  	%>
  	<!-- pageContext -->
  	<%
  		pageContext.setAttribute("name","white");
  		String scope = (String)pageContext.getAttribute("name");
  		//使用findAttribute方法从四个空间中获取存储对象
  		  		
  	%>
  	<!-- exception -->
  	<!--
  		<%@ page lanuage="java" pageEncoding="UTF-8" errorPage="true" %>
  		指定错误页面为error.jsp 
  	 -->
  	 
  </body>
</html>
