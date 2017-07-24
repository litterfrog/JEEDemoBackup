<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="testConversionServiceConverter" method="post">
		lastname-email-gender-department.id
		Employee:<input type="text" name="employee"/>
		<input type="submit" value="submit"/>
	</form>
	<!-- 可以更快速的开发出表单页面，而且可以更方便的进行表单值得回显 
		注意：
			可以通过modelAttribute属性指定绑定的模型属性，
			若没有指定该属性，则默认从request域对象中读取command的表单bean，
			如果该属性值也不存在，则发生错误-->
	<form:form action="${pageContext.request.contextPath }/empInput" method="POST" modelAttribute="employee">
		<!-- path属性对应html表单标签的那么属性 -->
		<form:errors path="*"></form:errors><br/>
		<c:if test="${employee.id==null }">
			LastName:<form:input path="lastName"/><form:errors path="lastName"/><br/><br/>			
		</c:if>
		<c:if test="${employee.id!=null }">
			<form:hidden path="id"/>
			<input type="hidden" name="_method" value="PUT"/>
		</c:if>
		email:<form:input path="email"/><form:errors path="email"/><br/>
		<%
			Map<String,String> genders=new HashMap<>();
			genders.put("1","male");
			genders.put("0","female");
			request.setAttribute("genders", genders);
		%>
		gender:<form:radiobuttons path="gender" items="${genders }"/><br/>
		department:<form:select path="department.id" items="${departments }"
						 itemLabel="departmentName" itemValue="id"/><br/>
		<!-- 
			1.数据类型转换
			2.数据类型格式化
			3.数据校验
			1)如何校验
				1>使用JSP303验证标准
				2>加入hibernate validator验证框架
				3>在SpringMVC配置文件中添加<mvc:annotation-driven/>
				4>需要在bean的属性上添加对应的注解
				5>在目标方法bean类型的前面添加@Valid注解
				注意：需要校验的Bean对象和其绑定结果对象或错误对象时成对出现的，它们之间不允许声明其他的入参
			2)验证出错转向到哪个页面			
			3)错误消息？如何显示，如何把错误消息进行国际化
		 -->
		birth:<form:input path="birth"/><form:errors path="birth"/><br/>
		salary:<form:input path="salary"/><br/>
		<input type="submit" value="submit"/>

	</form:form>
</body>
</html>