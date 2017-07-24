<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>structs2 register page</title>

<script type="text/javascript">
	
	function getCurrentDate(){
 		var date=new Date();
 		var year=date.getFullYear();
		var month=date.getMonth()+1;
		var day=date.getDate();
		return year+"-"+month+"-"+day;		
	}
	window.onload=function(){
		
		document.getElementById("registerDate").value=getCurrentDate();
		document.getElementById("dateDiv").innerHTML=new Date().toDateString();
	}

</script>
</head>
<body>
	<!-- HTML 注释 -->
	<h2>register please</h2>
	<center>
    <s:form action="register" method="post">
      <s:textfield label="姓名" name="user.name"/><br/>
      <s:password label="密码" name="user.password"/><br/>
      <s:textfield label="年龄" name="user.age"/><br/>
      <s:textfield label="日期" id="registerDate" name="user.registerDate" readOnly="readonly"/><br/>
      <s:submit  value="submit"/>
    </s:form>
	</center>
	<div id="dateDiv"></div>
</body>
</html>