<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<base href="/BookStore/" target="_parent"/>
<title>login,register</title>
</head>
<body>
	<header id="p_header">
		fxp在线书店
		<div></div>
	</header>
	<div id="login">
		<h3>登录</h3>
		<form action="do/user" method="post">
			<input type="hidden" name="op" value="login"/>
			用户名:<input name="name"/><c:if test="${login_err!=null }"><strong style="color:#f00">${login_err }</strong></c:if><br/>
			密码:<input name="password" type="password"/><br/>
			<button type="submit">登录</button><button type="button">找回密码</button>
		</form>
	</div>
	<div id="register">
		<h3>注册</h3>
		<form action="do/user" method="post">
		<input type="hidden" name="op" value="register"/>
			用户名:<input name="name"/><c:if test="${name_err!=null }"><strong style="color:#f00">${name_err }</strong></c:if><br/>
			密码:<input name="password" type="password"/><br/>
			验证:<input name="confirm" type="password"/><br/>
			邮箱:<input name="email"/><br/>
			<button type="submit">注册</button>
		</form>
	</div>
</body>
</html>