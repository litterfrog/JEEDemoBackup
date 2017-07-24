<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/BookStore/" target="_parent">


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>manager</title>
</head>

<body>
<h3>manager</h3>
<p>manager_page:${manager_page }</p>
<jsp:include  page="${empty manager_page ?'order/cart.jsp':manager_page }"/>
</body>
</html>