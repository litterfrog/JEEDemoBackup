<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
%>
<%!
	private int count=5;
	int add(int a,int b){
		return a+b;
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp脚本</title>
</head>
<body>
	<%
		int result=add(5, 10);
	%>
	count:<%=count %>
	<br/>
	result:<%=result %>
	<br/>
	循环:
	<%for(int i=0;i<count;i++){%>
			<li><%=i %></li>
	<%}%>
</body>
</html>