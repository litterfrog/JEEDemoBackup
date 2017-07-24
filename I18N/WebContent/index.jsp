<%@page import="java.util.Date"%>
<%@page import="java.util.ResourceBundle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${pageContext.request.locale}"/>
<fmt:setBundle basename="message" var="msg"></fmt:setBundle>
<!-- 通过小脚本演示实现过程 -->
<%
	ResourceBundle bundle=ResourceBundle.getBundle("message",request.getLocale());
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 通过小脚本输出 -->
<title><%=bundle.getString("title") %></title>
</head>
<body>
	网页语言:${pageContext.request.locale}<br/>
	<!-- 通过I18N标签输出 -->
	<fmt:message key="title" bundle="${msg }"/>
	<hr/>
	<h3>格式化测试</h3>
	<fmt:formatNumber 
		value="11111.11"
		type="currency"
		var="cury"/>
	${cury }<br/>
	<fmt:formatDate value="<%=new Date() %>"
		type="date"
		var="now"/>
	${now }<br/>
</body>
</html>