<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="func" uri="http://com.fxp.jee.functions/myfunc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>EL表达式</title>
</head>
<body>
	2+3=${2+3}<br/>
	8%3=${8 mod 3 }<br/>
	<hr/>
	3==4=${3 eq 4 }<br/>
	3>4=${3 gt 4 }<br/>
	<hr/>
	3>4||4==4=${3>4 or 4==4 }<br/>
	!true=${not true }<br/>
	<hr/>
	user=${user}|
	<hr/>
	empty user=${empty user }<br/>
	<hr/>
	${request }<br/>
	${pageContext.request.locale }<br/>
	${pageContext.servletContext.contextPath }<br/>
	<hr/>
	<form action="control/doForm.jsp" method="post">
		<p>用户名:<input name="name"/></p>
		<p>密码:<input type="password" name="user-pwd"/></p>
		<p>
			<button type="reset">取消</button>
			<button type="submit">登录</button>
		</p>
	
	</form>
	<hr/>
	user-agent:<%=request.getHeader("user-agent") %><br/>
	user-agent:${header['user-agent'] }<br/>
	<hr/>
	Context-param:${initParam.test }
	<%
		Cookie cookie=new Cookie("test","123");
		response.addCookie(cookie);
	%>
	<hr/>
	EL调用自定义函数hi:${func:hi("小明") }
</body>
</html>