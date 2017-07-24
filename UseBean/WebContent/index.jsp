<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<form action="control/doLogin.jsp" method="post">
		<fieldset>
			<legend>用户登录</legend>
			<p>用户名:<input name="name"/></p>
			<p>密　码:<input type="password" name="pwd"/></p>
			<p>
				<button type="reset">取消</button>
				<button type="submit">登录</button>
			</p>
		</fieldset>
	</form>
</body>
</html>