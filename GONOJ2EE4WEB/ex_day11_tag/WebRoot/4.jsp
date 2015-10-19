
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/bmy.tld" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>      
    <title>foreach迭代的标签</title>  	
  </head>
  
  <body>
    <%
    	List list = new ArrayList();
    	list.add("L");
    	list.add("O");
    	
    	request.setAttribute("list",list);
    %>
    
    <c:foreach var="str" items="${list}">
    ${str }
    </c:foreach>
    
    <br/><hr><br/>
    <%
    	list = new ArrayList();
    	list.add("b");
    	list.add("m");
    	list.add("y");
		request.setAttribute("list",list);
		
		Integer arr[] = new Integer[]{1,2,3};
		request.setAttribute("arr",arr);
		
		Map map = new HashMap();
		map.put("B","believe");
		map.put("C","ComeOn");
		request.setAttribute("map",map);
		
    %>
    
    <c:foreach2 items="${list}" var="str">
    	${str }
    </c:foreach2>
    
     <br/><hr><br/>
    
    <c:foreach2 items="${arr}" var="num">
    	${num }
   	</c:foreach2>
   	
   	 <br/><hr><br/>
   	 
   	 <c:foreach2 items="${map}" var="me">
   	 	${me.key }=${me.value }<br/>
   	 </c:foreach2>
   	 
   	  <br/><hr><br/>
   	  <!-- 注意：基本数据类型数组的迭代 -->
   	  <%
   	  	int i[] = new int[]{1,2,3};
   	  	request.setAttribute("i",i);
   	  	
   	  	byte b[] = new byte[]{4,5,6};
   	  	request.setAttribute("b",b);
   	  	
   	  %>
     <c:foreach2 items="${i}" var="num">
     	${num }
     </c:foreach2>
     
      <br/><hr><br/>
      
      <c:foreach2 items="${b}" var="num">
      	${num }
      </c:foreach2>
  </body>
</html>
