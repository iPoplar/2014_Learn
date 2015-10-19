<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>添加日志</title>
<style type="text/css">
	body{
		font-family: 微软雅黑;
	}
</style>
<script type="text/javascript">
	function onBtnCommitClick(){
		var blogTitle;

		//教研 blogTitle 是否为空   长度不能超过 256

		var frm = document.getElementById("frmAddBlog");
		frm.submit();
	}
</script>
</head>
<body>
	<jsp:include page="../common/header.jsp"></jsp:include>
	
	<div style="position:relative; margin:0px auto;width:1024px;">
		<div role="page-content" style="position:absolute;top:42px;width:100%;">
			<form id="frmAddBlog" action="addBlog" method="post">
				<table style="width:100%;">
					<tr>
						<td width="80" align="center">标&nbsp;&nbsp;&nbsp;&nbsp;题</td>
						<td>
							<input name="blogTitle" type="text" style="height:30px;width:100%;">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<textarea name="blogContent" style="height:400px;width:100%;" rows="" cols=""></textarea>
						</td>
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input style="padding:3px 10px 3px 10px;font-family:微软雅黑;font-size:16pt;" 
								type="button" value="提交" onclick="onBtnCommitClick();">
							<input style="padding:3px 10px 3px 10px;font-family:微软雅黑;font-size:16pt;" type="button" value="取消">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>
	
	<jsp:include page="../common/footer.jsp"></jsp:include>
</body>
</html>