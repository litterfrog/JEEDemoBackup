<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>JSP简介</title>
</head>
<body>
	<!-- HTML 注释 -->
	<%-- JSP 注释 --%>
	<%
		int age=20;
	%>
	年龄:<%=age %><br/>
	${'hello EL' }<br/>
	<jsp:include page="include.jsp"></jsp:include>
	<f:formatDate value="<%=new java.util.Date() %>" pattern="yyyy-MM-dd HH:mm:ss"/>
</body>
</html>