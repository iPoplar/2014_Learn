<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<%String context = request.getContextPath(); %> 
    
    <title>通配符的练习</title>
    
	
  </head>
  
<body>

	使用通配符，将配置降到最低<br/>
	<a href="<%=context %> /actions/Studentadd"> 添加学生</a>
	<a href="<%=context %>/actions/Studentdelete"> 删除学生</a>
	<br/>
	不过，一定要遵守“约定优于配置”的原则
	<br/>
	<a href="<%=context %>/actions/Teacher_add">添加老师 </a>
	<a href="<%=context %>/actions/Teacher_delete">删除老师</a>
  
  <!--
   使用通配符，将配置量降到最低<br />
<a href="<%=context %>/actions/Studentadd">添加学生</a>
<a href="<%=context %>/actions/Studentdelete">删除学生</a>
<br />
不过，一定要遵守"约定优于配置"的原则
<br />
<a href="<%=context %>/actions/Teacher_add">添加老师</a>
<a href="<%=context %>/actions/Teacher_delete">删除老师</a>
<a href="<%=context %>/actions/Course_add">添加课程</a>
<a href="<%=context %>/actions/Course_delete">删除课程</a>
	
  --></body>
</html>
