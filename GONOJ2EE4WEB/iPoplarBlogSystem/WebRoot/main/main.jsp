<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>welcome iPoplar Blog</title>  
    <jsp:include page="../style/head.jsp"></jsp:include>
    <jsp:include page="../style/foot.jsp"></jsp:include>
    <style>
    	
    	
    	.divUserInfo{
    		width:200px;
    		height:400px;
    		border:1px solid black;
    		display:inline-block; 
    		position:relative;
    		top:100px;
    		left:100px;   		
    	}
    	
    	.divButton{
    		width:200px;
    		height:30px;
    		background:#67B3E1;
    	}
    	
    	.divTable{
    		width:830px;
    		height:200px;
    		position:relative;
    		top:-300px;
    		left:304px;
    		overflow:auto;
    	}
    
    	.divUserImg{
    		width:200px;
    		height:200px;
    		background:lightgray;
    	}

    	.divTop{
    		width:830px;
    		height:30px;
    		font:black;    		
    		background:#67B3E1;
    	}
    	
    	table{
    	width:800px;
    	}
    	
</style>
  </head>
  
  <body>
  	<div class="divBlog">
  		<div class="divUserInfo">
  			<div class="divUserImg" >
  			</div>
  			<div class="divButton">
  			</div>
  		</div>
  		
  		<div class="divTable">
  		<div class="divTop top1">我的日志</div>
  		<table>
 			<th>日志标题</th>
			<th>创建时间</th>
			<th>作者</th>
  		</table>
  		</div>
  		
  		<div class="divTable">
  		<div class="divTop top2">好友日志</div>
  		<table>
  			<th>日志标题</th>
			<th>创建时间</th>
			<th>作者</th>
			
			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>
  		</table>
  		</div>
  	</div>	
    
  </body>
</html>
