<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>index.jsp</title>
    <script type="text/javascript" src="./js/Ajax.js"></script>
    <script type="text/javascript">
    	function success(responseText)
    	{
    		/**
    			将字符串解析成josn对象 两种方法    			    			
    		*/
    		
    		/*方法1
    			alert("This is SUCCESS: "+ resonseText);
    			var cmdStr = "var jsonObj = " + responseText;
    			window.eval(cmdStr);    			
    		*/
    		/*方法2*/
    		var funStr = "var jsonObj = " + responseText + "; return jsonObj;
    		var func = new Function(funStr);   		
    		
    		alert(func()); 
    	}
    	
    	function failure(responseText)
    	{
    		alert("This is FAILURE: " + resonseText);
    	}
    	
    	function onBtnClick()
    	{
    		var xmlReqObj;
    		if(window.XMLHttpRequest == null)
    		{
    			try{
    				xmlReqObj = new ActiveXObject("Microsoft.XMLHTTP");
    			}catch(e)
    			{
    				xmlReqObj = new ActiveXObject("Msxml2.XMLHTTP");
    			}    			
    		}
    		else
    		{
    			xmlReqObj = new XMLHttpRequest();
    		}
    		
    		xmlReqObj.open("post","./testJson.action", true);
    		xmlReqObj.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    		xmlReqObj.onreadystatechange = function()
    		{
    			if(xmlReqObj.readyState == 4)
    			{
    				if(xmlReqObj.status >= 200 && xmlReqObj.status < 400)
    				{
    					success(xmlReqObj.responseText);
    				}
    				else
    				{
    					failure(xmlReqObj.responseText);
    				}
    			}
    		};
    		
    		xmlReqObj.send("userName=postabcde&password=2222222");
    	}
    	
    	function testAjax()
    	{
    		var ajaxObj = new Ajax(
    		{
    			url: './testJson.action',
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
    		}
    		);
    		
    		ajaxObj.send();
    	}
    </script>
    
    
    	
  </head>
  
  <body>
    <input type="button" value="click" onclick="onBtnClick()">
    <input type="button" value="text Ajax" onclick="testAjax()">
    <input type="text">
  </body>
</html>
