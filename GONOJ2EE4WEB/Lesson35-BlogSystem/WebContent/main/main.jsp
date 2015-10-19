<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Date" %>
<%
	String userName = (String)session.getAttribute("userName");
	if(userName == null){
		response.sendRedirect("view/loginErrorView");
		return;
	}
	String basePath = application.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
	body{
		font-family: 微软雅黑;
	}
	
	.btn-add{
		margin:0px auto;
		height:30px;
		line-height:30px;
		width:196px;
		background:black;
		text-align:center;
		color:white;
	}
	
	.btn-add:hover{
		cursor:pointer;
		background:white;
		color:black;
		border: 1px solid black;
		height:28px;
		width:194px;
	}
	
	.tr-gray{
		background : lightgray;
	}
	
	.tr-base{
		cursor:pointer;
	}
	
	.tr-base:hover{
		background : black;
		color : white;
	}
</style>

<script type="text/javascript" src="../js/Ajax.js"></script>
<script type="text/javascript">
	function onBtnAddBlogClick(){
		window.open("<%=basePath%>/main/addBlog.jsp");
	}

	function loadMyBlogList(){
		var ajaxObj = new Ajax({
			url : './getUserBlogList.action',
			method : 'get',
			data : {},
			success : function(responseText){
				document.getElementById("divLoadingModal").style.display = "none";
				var table = document.getElementById("tableMyBlogList");
				var cmdStr = "var jsonObj = " + responseText;
				eval(cmdStr);
				for(var i = 0; i < jsonObj.blogList.length; i++){
					var blogTitle = jsonObj.blogList[i].blogTitle;
					var createTime = jsonObj.blogList[i].createTime;
					var tr = table.insertRow(table.rows.length);

					var td = tr.insertCell(0);
					td.innerHTML = blogTitle;
					td = tr.insertCell();
					td.innerHTML = createTime;
					td = tr.insertCell();
					td.innerHTML = jsonObj.userName;
				}
			}
		});
		ajaxObj.send();
	}

	function onBodyLoad(){
		loadMyBlogList();
	}
</script>
</head>
<body onload="onBodyLoad()">
	<jsp:include page="../common/header.jsp"></jsp:include>
	<div style="position:relative; margin:0px auto;width:1024px;">
		<div role="page-content" style="position:absolute;top:42px;width:100%;">
			<div role="content-left" style="width:200px;border:1px solid black;float:left;height:400px;">
				<div role="user-head-img" style="width:196px;height:196px;background:lightgray;margin:2px auto;"></div>
				
				<div role="button" class="btn-add" onclick="onBtnAddBlogClick()">
					添加日志
				</div>
			</div> 
			
			<div role="content-right" style="width:816px;float:left;padding:0px 3px 3px 3px;">
				<div style="margin-bottom:5px;height:260px;">
					<div style="height:30px;line-height:30px;width:100%;background:black;color:white;padding-left:10px;">
						我的日志
					</div>
					<div style="position:relative;:230px;height:200px;overflow: auto;padding-left:10px;">
						<table id="tableMyBlogList" style="width:100%;">
							<tr>
								<th>日志标题</th>
								<th>创建时间</th>
								<th>作者</th>
							</tr>
							
						</table>
						
						<div id="divLoadingModal" style="text-align:center;color:black;line-height:200px;position:absolute;width:calc(100% - 20px);height:100%;background:gray;opacity:0.8;">
							Loading...
							<img alt="" width="32" src="../resources/images/loading.gif" style="position:absolute;top:calc(50% - 16px);left:calc(50% - 104px);">
						</div>
					</div>
				</div>
				
				<div style="margin-bottom:5px;">
					<div style="height:30px;line-height:30px;width:100%;background:black;color:white;padding-left:10px;">
						朋友的日志
					</div>
					<div style="height:200px;overflow: auto;padding-left:10px;">
						<table style="width:100%;">
							<tr>
								<th>日志标题</th>
								<th>创建时间</th>
								<th>作者</th>
							</tr>
							
						</table>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>