<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- 
	SpringMVC处理静态资源：
	1.为什么会有这样的问题
	优雅的REST风格的资源URL不希望带.html或.do等后缀
	若将DispatcherServlet请求映射配置为/,
	则SpringMVC将捕获WEB容器的所有请求，包括静态资源的请求，SrpingMVC会将他们当做普通请求处理
	因找不到对应处理器将导致错误。
	2.解决：
	在SpringMVC的配置文件中配置<mvc:default-servlet-handler/>
 -->
<script type="text/javascript" src="scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(function(){
		$(".empDelete").click(function(){
			var $href=$(this).attr("href");
			$("#empDeleteForm").attr("action",$href).submit();
			return false;
		});
	})
</script>
<title>list</title>
</head>
<body>
	<form id="empDeleteForm" action="" method="post">
		<input type="hidden" name="_method" value="DELETE"/>
	</form>
	<c:if test="${empty requestScope.employees }">
		没有任何员工信息
	</c:if>
	<c:if test="${!empty requestScope.employees }">
		<table border="1" cellpadding="10" cellspacing="0">
			<tr>
				<td>ID</td>
				<td>LASTNAME</td>
				<td>EMAIL</td>
				<td>GENDER</td>
				<td>DEPT</td>
				<td>DELETE</td>
				<td>EDIT</td>
			</tr>
			<c:forEach items="${requestScope.employees }" var="emp">
			<tr>
					<td>${emp.id }</td>
					<td>${emp.lastName }</td>
					<td>${emp.email }</td>
					<td>${emp.gender==0?'female':'male' }</td>
					<td>${emp.department.departmentName }</td>
					<td><a class="empDelete" href="empInput/${emp.id }">delete</a></td>
					<td><a href="empInput/${emp.id }">edit</a></td>
			</tr>
			</c:forEach>
		</table>
	</c:if>
	<br/>
	<a href="empInput">add new emp</a>
</body>
</html>