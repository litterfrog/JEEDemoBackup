<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean id="user" class="com.fxp.jee.entity.User" scope="request"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<jsp:setProperty  name="user" value="${param['user-pwd'] }" property="password"/>
<jsp:forward page="../show.jsp"></jsp:forward>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>doForm</title>
</head>
<body>
 用户名：<%=request.getParameter("name") %>
 密码：<%=request.getParameter("user-pwd") %>
 <hr/>
 <h3>EL表达式</h3>
 用户名：${param.name }<br/>
 <!-- 这样是不行的，有'-'时要用[] -->
 <!-- 密码：${param.user-pwd }<br/> -->
 密码：${param['user-pwd'] }<br/>
 <hr/>
 cookie:${cookie.test.value}<br/>
 <hr/>
</body>
</html>