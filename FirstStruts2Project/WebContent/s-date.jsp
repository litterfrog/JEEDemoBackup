<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>s:date test</title>
</head>
<body>
	<s:bean name="java.util.Date" var="now" />
	<s:date name="#now" format="dd/MM/yyyy" nice="false"/><hr/>
	<s:date name="#now" nice="false"/><hr/>
	<s:date name="#now" format="dd/MM/yyyy" nice="true"/><hr/>
</body>
</html>