<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>login.jsp</title>  	
  </head>
  
  <body>
  	<!-- 练习1 -->
    <%
    	String name = request.getParameter("userName");
    	String pwd = request.getParameter("userPwd");
    	if(name.equals("bai")&&pwd.equals("88"))
    	{
    		out.println("欢迎您！"+ name);
    	}
    	else
    	{
    		out.println("用户名或密码错误!");
    	}
    	
    %>
    <!-- 练习2 -->
    <%
    	int count = 3;//错误次数
    	String name1 = request.getParameter("userName");
    	String pwd1 = request.getParameter("userPwd");
    	
    	Integer num1 = (Integer) session.getAttribute("errorCount");
    	
    	if(num1 == null)
    	{
    		num1 = 0;
    	}
    	if(num1 >= count)
    	{
    		out.print("错误次数已达上限!");
    	}else
    	{
    		if(name.equals("white")&&pwd.equals("88"))
    		{
    			Cookie namecookie = new Cookie("userName",name);
    			Cookie pwdCookie = new Cookie("usePwd",pwd);
    			response.addCookie(namecookie);
    			response.addCookie(pwdCookie);
    			out.print("欢迎您!"+ name);
    		}
    		else
    		{
    			out.println("用户名或密码错误!");
    			session.setAttribute("errorCount",++num1);
    			out.print("您还有"+ (count - (num1 -1))+"次机会！");
    		}
    	}
    	
    %>
  </body>
</html>
