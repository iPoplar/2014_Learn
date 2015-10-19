<%@ page language="java" import="java.util.*",import="java.sql.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>登陆数据处理</title>  	
  </head>
  
  <body>
   <%
   //获取登陆的数据
   	String name = request.getParameter("username");
   	String password = request.getParameter("password");
   	/*
   	//在数据库进行查询验证
   	
   	//1.加载驱动（此处的驱动是sqlServer的）要记住常用链接
   	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
   	//2.得到链接
   	Connection ct = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:54188","root","root");
   	//3.创建Statement
   	Statement sm = ct.createStatement();
   	
   	//4.查询
   	ResultSet rs = sm.executeQuery("select password from user where username='"+name);
   */
   
   	/*
   //对登陆数据进行简单验证
   if(name.equals("bmy")&& password.equals("123"))
   {
	  response.sendRedirect("wel.jsp?user="+name);
   }
   else
   {
	   response.sendRedirect("login.jsp");
   }
   	*/
  %>
  </body>
</html>
