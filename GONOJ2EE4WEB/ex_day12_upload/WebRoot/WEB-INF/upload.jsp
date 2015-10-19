<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>上传</title>  	
  </head>
  
  <body>
     //如果表单的提交类型为multipart/form-data的话，在servlet方就不能采用传统方式获取表单数据
    <form action="${pageContext.request.contextPath }/servlet/UploadServlet3" enctype="multipart/form-data" method="post">
    	上传用户：<input type="text" name="username"><br/>
    	上传文件1：<input type="file" name="file1"><br/>
    	上传文件2：<input type="file" name="file2"><br/>
    	
    	<input type="submit" value="提交">
    </form>
    
  </body>
</html>
