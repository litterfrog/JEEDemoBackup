<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//request的characterEncoding设置要在getParameter之前。
	request.setCharacterEncoding("UTF-8");
	String userName=request.getParameter("userName");
	String userBirth=request.getParameter("userBirth");	
	if(request.getMethod().equals("GET")){
		out.println("GET:userName"+userName+",your birth is "+userBirth);
	}else{
		out.println("POST:userName"+userName+",your birth is "+userBirth);
	}

%>