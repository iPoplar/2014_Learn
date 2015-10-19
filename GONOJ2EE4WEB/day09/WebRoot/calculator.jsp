<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>计算器</title>  	
  </head>
  
  <body>
  <jsp:useBean id="CalculatorBean" class="cn.bmy.CalculatorBean"></jsp:useBean>
	<jsp:setProperty name="CalculatorBean" property="*"/>
	<%
		CalculatorBean.calculate();
	%>
	<br/><hr> <br/>
	计算结果是：
	 <jsp:getProperty name="CalculatorBean" property="firstNum"/>
    <jsp:getProperty name="CalculatorBean" property="operator"/>
    <jsp:getProperty name="CalculatorBean" property="secondNum"/>
      =
    <jsp:getProperty name="CalculatorBean" property="result"/>
	<br/><hr> <br/>
	
	<form action="/day09/calculator.jsp" method="post">
	<table>
		<tr>
			<td colspan="2">简单的计算器</td>
		</tr>
		
		<tr>
			<td>第一个参数</td>
			<td>
				<input type="text" name="firstNum">
		
			</td>
			
		</tr>
		
		<tr>
			<td>运算符</td>
			<td>
				<select name="operator">
					<option  value="+">+</option>
					<option value="-">-</option>
    				<option value="*">*</option>
    				<option value="/">/</option>
    			</select>
    		
    		</td>
    	</tr>
    	
    	<tr>
    		<td>第二个参数</td>
    		<td>
    			<input type="text" name="secondNum">
    		</td>
    	</tr>
    	
    	<tr>
    		<td colspan="2">
    			<input type="submit" value="计算">
    		</td>
    	</tr>
	</table>
	</form>

	</body>
</html>
