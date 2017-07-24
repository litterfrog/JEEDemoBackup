<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>s:action test</title>
</head>
<body>
	调用第一个Action,将结果包含进来<br/>
	<s:action name="tagTest" executeResult="true"></s:action>
	调用第二个Action,将结果包含进来，阻止参数传入Action<br/>
	<s:action name="process" executeResult="true" ignoreContextParams="true"></s:action>
	调用第二个Action,不将结果包含进来	<br/>
	<s:action name="process" executeResult="false"></s:action>
	请求参数:<s:property value="#parameters.msg"/><!-- url地址里边加入参数 -->
</body>
</html>