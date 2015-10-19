<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>Register</title>  
    <link href="../style/style.css" rel="stylesheet" />
    <style>
    	.divBox{
    		width:380px;
    		height:410px;
    		margin:0 auto;
    		position:relative;
    		top:50px;
    	}
    </style>
  </head>
  
  <body>
  <div class="divBox">  
  <form>
			<table>
				<tr>
					<th colspan="2">Poplar Blog</th>
				</tr>

				<tr>
					<td>用户名:</td>
					<td><input type="text" name = "userName"/></td>
				</tr>

				<tr>
					<td>密码:</td>
					<td><input type="password" name = "password" /></td>
				</tr>

				<tr>
					<td>确认密码:</td>
					<td><input type="password" name = "SurePassword" /></td>
				</tr>

				<tr>
					<td>性别:</td>
					<td>
					<input type="radio"  name = "Sex" /> 男
					<input type="radio"  name = "Sex" /> 女
					</td>
				</tr>

				<tr>
					<td>出生日期:</td>
					<td><input type="text" name = "Birthday" /></td>
				</tr>

				<tr>
					<td>个人简介:</td>
					<td>
						<textarea name="introduction" rows="5" cols="30"></textarea>
					</td>
				</tr>

				<tr>
					<td colspan="2" style="text-align:right">
						<input type="submit" value="注册" />
						<input type="reset" value="清空">
					</td>
				</tr>
			</table>
		</form>
		</div>
  </body>
</html>
