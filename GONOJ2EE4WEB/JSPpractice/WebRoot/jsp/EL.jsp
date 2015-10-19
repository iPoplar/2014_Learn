<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>EL表达式的练习</title>  	
  </head>
  
  <body>
    <!--
    	el表达式支持算术运算 +-*/%
    		支持关系运算符操作
    		支持字符关系运算符
    		支持逻辑运算 
     -->
     
     <!--
     	el表达式默认会从
     	pageContext、reqeust、session、application中按照此顺序寻找名称匹配的对象 
      -->
     
     12 + 15 = ${12+15 }<br>
     
     12 == 15 ${12 == 15 } <br>
     12 > 15 ${12 > 15 } <br>
     12 != 15 ${12 != 15 }<br>
     
     12 == 15 ${12 eq 15 } <br>
     12 < 15 ${12 lt 15 } <br>
     12 > 15 ${12 gt 15 } <br>
     12 <= 15 ${12 le 15 } <br>
     12 >= 15 ${12 ge 15 } <br>
     12 != 15 ${12 ne 15 } <br>
     
     ${12 < 15 && 12 < 15 } <br>
     ${12 < 15 and 12 < 15 } <br>
     ${ not(12 < 15) }
     
     <% 
     	List list = new ArrayList();
     	list.add("white");
     	pageContext.setAttribute("str",null);
     	pageContext.setAttribute("list",list);
     %>
     ${empty str }
     ${empty list }
     
     <!-- el 表达式中的字符串需要使用单引号引起来 -->
     ${12 < 15 ? 'yes' : 'no'}
     
     <!-- el表达式获取对象的属性值 -->
     <!-- 
     	User user = new User();
     	user.setAddress("巴西");
     	user.setName("white");
     	pageContext.setAttribute("user",user);
     	
     	===========
     	方法1：
     	${user.name}
     	${user.address}
     	方法2：
     	${user["name"]}
     	${user["address"]}
     	
      -->
     
  </body>
</html>
