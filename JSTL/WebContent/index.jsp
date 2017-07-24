<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index</title>
</head>
<body>
	<c:set value="${'<strong>page test</strong>' }" var="test"></c:set>
	<c:set value="${'<strong>request test</strong>' }" var="test" scope="request"></c:set>
	pageScope转义:<c:out value="${pageScope.test }"></c:out><br/>
	pageScope未转义:<c:out value="${pageScope.test }" escapeXml="false" ></c:out><br/>
	requestScope:<c:out value="${requestScope.test }">
					<strong>default</strong>
				 </c:out><br/>
	<hr/>
	<strong>remove</strong><br/>
	<!-- 不指定作用域就移除所有作用域 -->
	<c:remove var="test" scope="page"/>
	pageScope未转义:<c:out value="${pageScope.test }" escapeXml="false" ></c:out><br/>
	requestScope:<c:out value="${requestScope.test }">
					<strong>default</strong>
				 </c:out><br/>
	<hr/>
	<h3>条件标签测试</h3>
	<form action="doAge.jsp" method="post">
		年龄:<input name="age"/><br/>
		<button type="submit">提交</button>
		
	
	</form>
	<hr/>
	<h3>迭代标签测试</h3>
	<strong>forEach</strong><br/>	
	<%
		int[] arr={13,23,33,4,4,4,4,10};
	%>
	<c:forEach items="<%=arr %>" var="num" varStatus="status" begin="2">
		${status.count }:${num }<br/>
	</c:forEach>
	<strong>forTokens</strong><br/>	
	<c:forTokens items="ab,ee;44|123" delims=",;|" var="item">
		${item }<br/>
	</c:forTokens>
	<hr/>
	<h3>导入及重定向标签测试</h3>
	<c:url value="doAge.jsp" var="age"></c:url>
	${age }
	<c:import url="http://www.baidu.com" charEncoding="UTF-8"></c:import>
	<c:redirect url="${age }">
		<c:param name="age" value="33"></c:param>
	</c:redirect>
</body>
</html>