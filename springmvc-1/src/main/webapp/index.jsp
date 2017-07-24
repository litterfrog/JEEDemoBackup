<html>
<body>
<a href="helloworld">helloworld</a><br/>
<a href="springmvc/testRequestMapping">testRequestMapping</a><br/>
<a href="springmvc/testMethod">testMethod</a><br/>
<form action="springmvc/testMethod" method="post">
	<input type="submit" value="submitpost"/>
</form><br/>
<a href="springmvc/testParamsAndHeaders?username=fxp&age=2">testParamsAndHeaders</a><br/>
<a href="springmvc/testAntPath/ab/ant">testAntPath</a><br/>
<a href="springmvc/testPathVariable/1">testPathVariable</a><br/>

<a href="springmvc/testRest/1">test Rest GET</a><br/>
<form action="springmvc/testRest/" method="post">
	<input type="submit" value="test Rest POST">
</form><br/>
<form action="springmvc/testRest/1" method="post">
	<input type="hidden" name="_method" value="DELETE">
	<input type="submit" value="test Rest DELETE">
</form><br/>
<form action="springmvc/testRest/1" method="post">
	<input type="hidden" name="_method" value="PUT">
	<input type="submit" value="test Rest PUT">
</form><br/>
<a href="springmvc/testRequestParam?username=fxp&age=10">testRequestParam</a><br/>
<a href="springmvc/testRequestHeader">testRequestHeader</a><br/>
<a href="springmvc/testCookieValue">testCookieValue</a><br/>

<form action="springmvc/testpojo" method="post">
	username:<input type="text" name="username"/><br/>
	password:<input type="password" name="password"/><br/>
	email:<input type="text" name="email"/><br/>
	age:<input type="text" name="age"/><br/>
	city:<input type="text" name="address.city"/><br/>
	province:<input type="text" name="address.province"/><br/>
	<input type="submit" value="submit"/>
</form><br/>

<a href="springmvc/testServletAPI">testServletAPI</a><br/>

<a href="springmvc/testModelAndView">testModelAndView</a><br/>

<a href="springmvc/testMap">testMap</a><br/>

<a href="springmvc/testSessionAttributes">testSessionAttributes</a><br/>

<!-- 模拟修改操作
	1.原始数据为：1，tom，123，tom@111，12 
	2.密码不能修改。
	3.表单回显，模拟操作直接在表单填写对应的属性值-->
<form action="springmvc/testModelAttribute" method="post">
	<input type="hidden" name="id" value="1"/><br/>
	username:<input type="text" name="username" value="Tom"/><br/>
	email:<input type="text" name="email" value="Tom@111"/><br/>
	age:<input type="text" name="age" value="11"/><br/>	
	<input type="submit" value="submit"/><br/>
</form>

<a href="springmvc/testViewAndViewResolver">testViewAndViewResolver</a><br/>

<a href="springmvc/testView">testView</a><br/>

<a href="springmvc/testRedirect">testRedirect</a><br/>
</body>
</html>
