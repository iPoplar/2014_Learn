<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>Login</title>
    <link href="../style/style.css" rel="stylesheet" />
    <style>
    	.divBox{
    		width:400px;
    		height:175px;
    		margin:0 auto;    		
    		position:relative;    		
    		top:calc(50% - 150px);    		
    	}
    </style>  	
  </head>
  
  <body>
    <div class="divBox">
		<table>
			<tr>
				<th colspan="2" class="headLine">Poplar Blog Login</th>
			</tr>

			<tr>
				<td>用户名:</td>
				<td><input type="text" name="userName" /></td>
			</tr>

			<tr>
				<td>密码:</td>
				<td><input type="password" name="password" /></td>
			</tr>


			<tr>
				<td>确认密码:</td>
				<td><input type="password" name="SurePassword" /></td>
			</tr>
		</table>
	</div>
  </body>
</html>
