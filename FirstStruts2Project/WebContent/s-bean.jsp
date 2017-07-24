<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>s:bean test</title>
</head>
<body>
	<s:bean name="com.fxp.pojo.User" var="user">
		<s:param name="name" value="'赵日天'"/>
		<s:param name="age" value="39"/>
		name:<s:property value="name"/><br/>
		age:<s:property value="age"/><br/>
	</s:bean>
	User的name是:<s:property value="#user.name"/><br/>
	User的age是:<s:property value="#user.age"/><br/>
</body>
</html>