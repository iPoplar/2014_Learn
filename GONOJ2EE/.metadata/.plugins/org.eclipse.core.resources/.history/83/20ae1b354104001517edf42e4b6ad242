<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Date" %>
<%
	String userName = (String)session.getAttribute("userName");
	if(userName == null){
		response.sendRedirect("view/loginErrorView");
		return;
	}
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
<script type="text/javascript">
	function onBtnAddBlogClick(){
		window.open("./addBlog.jsp");
	}
</script>
</head>
<body>
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
					<div style="height:230px;overflow: auto;padding-left:10px;">
						<table style="width:100%;">
							<tr>
								<th>日志标题</th>
								<th>创建时间</th>
								<th>作者</th>
							</tr>
							
							<%
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								Connection conn = DriverManager.getConnection("jdbc:odbc:BlogServerDb");
								String sql = "select blog_title, create_time from user_blog_info where user_name = '"+ userName +"'";
								System.out.println(sql);
								PreparedStatement stmt = conn.prepareStatement(sql);
								ResultSet rst = stmt.executeQuery();
								int i = 0;
								while(rst.next()){
									String blogTitle = rst.getString("blog_title");
									String createTime = rst.getString("create_time");
									if(i % 2 == 0){
										out.println("<tr class='tr-base tr-gray'>");
									}else{
										out.println("<tr class='tr-base'>");
									}
									i++;
							%>
									<td><%=blogTitle %></td>
									<td><% out.print(createTime); %></td>
									<td><% out.print(userName); %></td>
								</tr>
							<%
								}
							%>
						</table>
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
							
							<%
								Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
								conn = DriverManager.getConnection("jdbc:odbc:BlogServerDb");
								sql = "select blog_title, create_time from user_blog_info where user_name = '"+ userName +"'";
								System.out.println(sql);
								stmt = conn.prepareStatement(sql);
								rst = stmt.executeQuery();
								i = 0;
								while(rst.next()){
									String blogTitle = rst.getString("blog_title");
									String createTime = rst.getString("create_time");
									if(i % 2 == 0){
										out.println("<tr class='tr-base tr-gray'>");
									}else{
										out.println("<tr class='tr-base'>");
									}
									i++;
							%>
									<td><%=blogTitle %></td>
									<td><% out.print(createTime); %></td>
									<td><% out.print(userName); %></td>
								</tr>
							<%
								}
							%>
						</table>
					</div>
				</div>
			</div>
			
		</div>
	</div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>