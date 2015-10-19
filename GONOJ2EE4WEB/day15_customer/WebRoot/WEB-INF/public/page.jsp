<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

当前第[${page.pagenum }]页&nbsp;&nbsp;&nbsp;
<c:if test="${page.pagenum>1 }">
<a href="${page.url }?pagenum=${page.pagenum-1 }">上一页</a>

</c:if>

