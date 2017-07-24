<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="com.fxp.jee.entity.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户信息</title>
</head>
<body>
	用户名：${user.name }<br/>
	密码：${user.password }
	<hr/>
	小脚本<br/>
	<%
		User user=(User)pageContext.findAttribute("user");
	%>
	用户名：<%=user.getName() %>

	密码：<%=user.getPassword() %>
</body>
</html>