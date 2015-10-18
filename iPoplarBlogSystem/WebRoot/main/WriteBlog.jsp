<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>Write Blog</title> 
    <jsp:include page="../style/head.jsp"></jsp:include>
    <jsp:include page="../style/foot.jsp"></jsp:include> 
    <style>
    	.divBox{
    		position:relative; 
    		margin:0px auto;
    		width:1024px;
    	}
    	
    	.pageContent{
    		position:absolute;
    		top:60px;
    		width:100%;
    	}
    	
    	table{
    		width:100%;
    	}
    	
    	.tdTop{
    		width:80px;
    		text-align:center;
    	}
    	
    	.inTitle{
    		height:30px;
    		width:100%;
    	}
    	
    	.textArea{
    		height:400px;
    		width:100%;
    	}
    	
    	.ipBtn{
    		padding:3px 6px 3px 6px;
    		font-family:微软雅黑;
    		font-size:14pt; 
    	}
    </style>	
  </head>
  
  <body>
   <div class="divBox">
		<div class="pageContent">
			<form id="frmAddBlog" action="./servlet/addBlogServlet" method="post">
				<table>
					<tr>
						<td class="tdTop">标&nbsp;&nbsp;&nbsp;&nbsp;题</td>
						<td>
							<input name="blogTitle" type="text" class="inTitle">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="blogContent" class="textArea"  rows="" cols=""></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input class="ipBtn" 
								type="button" value="提交" onclick="onBtnCommitClick();">
							<input class="ipBtn"  type="button" value="取消">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
   
  </body>
</html>
