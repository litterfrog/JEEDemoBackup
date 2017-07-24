<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/*
	request.setCharacterEncoding("UTF-8");
	String name=request.getParameter("name");
	String password=request.getParameter("password");
	User user=new User();
	user.setName(name);
	user.setPassword(password);
	request.setAttribute("user", user);
	*/
%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="user" class="com.fxp.jee.entity.User" scope="request">
	<jsp:setProperty name="user" property="*"/>
	<!-- param是表单元素的名称，property是成员变量的名称。如果这两个名称完全相同，
		 则可以通过*来自动填充，如果不完全相同则就要通过下边的代码单独设置 -->
	<jsp:setProperty name="user" param="pwd" property="password"/>
</jsp:useBean>
<jsp:forward page="../welcome.jsp"></jsp:forward>