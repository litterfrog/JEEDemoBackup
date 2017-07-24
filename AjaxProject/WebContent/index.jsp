<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index</title>
<script type="text/javascript">
	var xmlHttp;
	function createXMLHttpRequest(){
		if(window.ActiveXObject){
			xmlHttp=new ActiveXObject("Microsoft.XMLHTTP");//IE5,6
		}else{
			xmlHttp=new XMLHttpRequest();//IE7,etc.
		}
	}
	function createQueryString(){
		var userName=document.getElementById("userName").value;
		var userBirth=document.getElementById("userBirth").value;
		var queryString="userName="+userName+"&userBirth="+userBirth;
		document.getElementById("test").innerHTML=queryString;
		return queryString;
	}
	/**
	当readyState属性值发生改变时就会激活此函数来执行
	*/
	function handleStateChange(){
		if(xmlHttp.readyState==4){
			if(xmlHttp.status==200){
				var content=xmlHttp.responseText;
				document.getElementById("content").innerHTML=content;
			}
		}
	}
	function startGet(){
		createXMLHttpRequest();
		var url="request.jsp?timestamp="+new Date().getTime();
		xmlHttp.open("get",url+"&"+createQueryString());
		xmlHttp.send(null);
		xmlHttp.onreadystatechange=handleStateChange;
	}
	function startPost(){
		createXMLHttpRequest();
		var url="request.jsp?timestamp="+new Date().getTime();
		xmlHttp.open("post",url);
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		xmlHttp.send(createQueryString());
		xmlHttp.onreadystatechange=handleStateChange;
	}
	window.onload=function(){
		document.getElementById("btnGet").onclick=startGet;
		document.getElementById("btnPost").onclick=startPost;
	}
</script>
</head>
<body>
	<h2>please input your name and birth</h2>
	<input type="text" name="userName" id="userName"><br/>
	<input type="text" name="userBirth" id="userBirth"><br/>
	<input type="button" name="btnGet" id="btnGet" value="get"><br/>
	<input type="button" name="btnPost" id="btnPost" value="post"><br/>
	<div id="content">
		
	</div><br/>
	<div id="test">
	</div>
</body>
</html>