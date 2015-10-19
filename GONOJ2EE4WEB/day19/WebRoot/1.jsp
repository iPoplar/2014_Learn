<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP '1.jsp' starting page</title>
  </head>
  
  <body>
  	欢迎您：${user.username }<br/><br/><br/>
  
    <!-- 权限数据的管理麻烦 -->
    <a href="/day19/manager/AddProduct">添加商品</a>
    <a href="/day19/manager/UpdateProduct">修改商品</a>
    <a href="/day19/manager/DeleteProduct">删除商品</a>
    
    <a href="/day19/manager/ShowOrder">查看订单</a>
     <a href="/day19/manager/UpdateOrder">修改订单</a>
  </body>
</html>
