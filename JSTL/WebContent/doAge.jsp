<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>doAge</title>
</head>
<body>
	<strong>${param.age }</strong><br/>
	<hr/>
	<h3>if标签</h3>
	<c:if test="${param.age<=18 }">
		少年
	</c:if>
	<c:if test="${param.age>18&&param.age<=30 }">
		青年
	</c:if>
	<c:if test="${param.age>30&&param.age<=50 }">
		中年
	</c:if>
	<c:if test="${param.age>50 }">
		老年
	</c:if>
	<hr/>
	<h3>choose标签</h3>
	<c:choose>
		<c:when test="${param.age<=18 }">
			少年
		</c:when>
		<c:when test="${param.age>18&&param.age<=30 }">
			青年
		</c:when>
		<c:when test="${param.age>30&&param.age<=50 }">
			中年
		</c:when>
		<c:otherwise>
			老年
		</c:otherwise>
	</c:choose>
</body>
</html>