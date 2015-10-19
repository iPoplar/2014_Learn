<%@ page language="java" import="java.util.*",import="java.sql.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>welcome</title>  	
  </head>
  
  <body>
    你好呀！<%=request.getParameter("user") %>
    <a href="login.jsp"> 返回重新登录</a>
    
    <!-- 对数据进行分页 -->
    
    <h1>用户信息列表</h1>
    <%
    	//定义四个分页会用到的变量
    	int pageSize=3;//每页显示多少条记录
    	int pageNow=1;//默认显示第一页
    	int rowCount=0;//一共多少条记录（从数据库查询）
    	int pageCount=0;//一共多少页
    	
    	//接收用户希望显示的页数(pageNow)
    	String s_pageNow = request.getParameter("pageNow");
    	
    	if(s_pageNow!=null)
    	{
    		//接收到pageNow
    		pageNow = Integer.parseInt(s_pageNow);
    	}
    	
    	//查询得到rowCount;
    	
    	//1.加载驱动
    	Class.forName("com.microsoft.jdbc.sqlserver.SQLServerDriver");
    	//2.得到链接
    	Connection ct = DriverManager.getConnection("jdbc:microsoft:sqlserver://127.0.0.1:54188;databaseName=mysqldb1","root","root");
    	//3.创建Statement
    	Statement sm = ct.createStatement();
    	//4.查询
    	ResultSet rs = sm.executeQuery("select count(*) from user");
    	
    	if(rs.next())
    	{
    		rowCount = rs.getInt(1);
    	}
    	
    	//计算pageCount，方法很多的
    	if(rowCount%pageSize==0)
    	{
    		pageCount=rowCount/pageSize;
    	}
    	else
    	{
    		pageCount=rowCount/pageSize+1;
    	}
    	
    	//查询出需要显示的记录
    	rs = sm.executeQuery("select top"+pageSize+"from users where userId not in (select top"+pageSize*(pageNow-1)+"userId from users)");
    	
    	//显示
    	%>
    		<table border="1">
    			<tr><td>用户id</td><td>用户名字</td><td>密码</td></tr>
    		<%
    			while(rs.next())
    			{
    				%>
    				<tr><td><%=rs.getInt(1) %></td><td><%=rs.getString(2) %></td></tr>
    				
    				<%
    			}
    		%>
    			
    		</table>    		
    		
    		<%
    			//上一页
    			if(pageNow!=1)
    			{
    				out.println("<a href=wel.jsp?pageNow="+(pageNow-1)+">上一页</a>");	
    			}
    		
    			//显示超链接
    			for(int i=0; i<pageCount; i++)
    			{
    				out.println("<a href=#>["+i+"]</a>");
    			}
    			
    			//下一页
    			if(pageNow!=pageCount)
    			{
    				out.println("<a href=wel.jsp?pageNow="+(pageNow+1)+">下一页</a>");	
    			}
    		%>
    	<%
    	
    %>
  </body>
</html>
