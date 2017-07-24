<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.fxp.jee.entity.User"%>
<%
	User user=(User)request.getAttribute("user");	
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎<%=user.getName() %></title>
</head>
<body>
	<strong>欢迎<%=user.getName() %>大魔王</strong>
	<p>password:<%=user.getPassword() %></p>
</body>
</html>