<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/Ajax.js"></script>
<script type="text/javascript">

	
	function success(responseText){
		//alert("This is SUCCESS : " + responseText);
		/* var cmdStr = "var jsonObj = " + responseText;
		window.eval(cmdStr); */

		var funStr =  "var jsonObj = " + responseText + "; return jsonObj";
		var func = new Function(funStr);
		
		alert(func());
	}

	function failure(responseText){
		alert("This is FAILURE : " + responseText);
	}	

	function onBtnClick(){	
		var xmlReqObj;
		if(window.XMLHttpRequest == null){
			try{
				xmlReqObj = new ActiveXObject("Microsoft.XMLHTTP");
			}catch(e){
				xmlReqObj = new ActiveXObject("Msxml2.XMLHTTP");
			}
		}else{
			 xmlReqObj = new XMLHttpRequest()
		}
		
		xmlReqObj.open("post", "./testJson.action", true);
		xmlReqObj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xmlReqObj.onreadystatechange = function(){
			if(xmlReqObj.readyState == 4){
				if(xmlReqObj.status >= 200 && xmlReqObj.status < 400){
					success(xmlReqObj.responseText);
				}else{
					failure(xmlReqObj.responseText);
				}
			}
		};
		xmlReqObj.send("userName=postabcde&password=333333");
	}

	function testAjax(){
		var ajaxObj = new Ajax({
			url:'./testJson.action',
			method : 'post',
			async : true,
			data : {
				userName : 'ajaxRequest',
				password : '1111111'
			},
			success : function(responseText){
				alert(responseText);
			},
			failure : function(responseText){
				alert(responseText);
			}
		});

		ajaxObj.send();
	}

	
</script>

</head>
<body>
	<input type="button" value="click" onclick="onBtnClick()">
	<input type="button" value="test Ajax" onclick="testAjax()">
	<input type="text">
</body>
</html>