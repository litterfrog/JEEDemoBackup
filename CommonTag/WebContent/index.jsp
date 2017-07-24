<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index</title>
</head>
<body>
	<%
		String str="in index";
	%>
	<jsp:include page="include/date.jsp">
		<jsp:param value="<%=str %>" name="str"/>
	</jsp:include>
	被include指令包含<%@ include file="include/date.jsp" %>
	<hr/>
	pageContext:<%=pageContext.getAttribute("test") %><br/>
	application:<%=application.getAttribute("test") %><br/>
	<hr/>
	<strong>这是index页面</strong>
	
</body>
</html>