<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>structs2 login page</title>
</head>
<body>
	<!-- HTML 注释 -->
	<h2>login please</h2>
	<center>
    <form action="login" method="post">
      <!-- map -->
      <p>map</p><br/>
      name1:<input type="text" name="usersMap['a'].name"/><br/>
      password1:<input type="password" name="usersMap['a'].password"/><br/>
      name2:<input type="text" name="usersMap['b'].name"/><br/>
      password2:<input type="password" name="usersMap['b'].password"/><br/>
      <!-- list -->
      <p>list</p><br/>
      name3:<input type="text" name="usersList[0].name"/><br/>
      password3:<input type="password" name="usersList[0].password"/><br/>
      name4:<input type="text" name="usersList[1].name"/><br/>
      password4:<input type="password" name="usersList[1].password"/><br/>
      <input type="submit" name="submit"/>
    </form>
     <form action="loginCustomCoverter" method="post">
      <p>customConverter,格式：用户名,密码</p><br/>
           用户信息:<input type="text" name="user"/><br/>
      <input type="submit" name="submit"/>
    </form>   
    fielderror:<s:fielderror/><br/>
    actionerror:<s:actionerror/><br/>
    <a href='<s:url action="listBook"/>'>浏览图书</a>
	</center>
</body>
</html>