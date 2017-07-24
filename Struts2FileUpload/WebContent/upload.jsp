<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>structs2 fileupload</title>
</head>
<body>
	<!-- HTML 注释 -->
	<h2>file upload</h2>
	<center>
	<s:fielderror/>
    <form action="uploadfile" method="post" enctype="multipart/form-data">
      	文件标题:<input type="text" name="title"/><br/>
		选择文件:<input type="file" name="upload"/><br/>
      	<input type="submit"  value="上传"/>
    </form>
    <a href="">文件下载</a>
	</center>
</body>
</html>