<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%System.out.println("index.jsp"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Fxp在线书店</title>
	<base href="/BookStore/" target="_parent"/>
	<style type="text/css" media="screen">
		@IMPORT url("css/common.css");
		@IMPORT url("css/index.css");
	</style>
</head>
<f:setLocale value="${pageContext.request.locale }"/>
<body>
	<header id="p_header">
		FXP在线书店
		<div></div>
	</header>
	<article>
		<header>
			图书列表
		</header>
		<c:forEach items="${books }" var="book">
		<figure>
			<a href="pages/book/detail.html"><img src="${book.image }"></a>
			<footer>
				${book.name }
				
			</footer>
			<figcaption>
				作者:${book.author } 单价:<f:formatNumber type="currency">${book.sellingPrice }</f:formatNumber>
				<a href="do/cart?id=${book.id }&op=add">加入购物车</a>
			</figcaption>
		</figure>
		</c:forEach>
		<nav class="list_nav">
			<div class="next"></div>
			<a href="index.html#top">1</a>
			<a href="index.html#top">2</a>
			<a href="index.html#top">3</a>
			<a href="index.html#top">4</a>
			<a href="index.html#top">5</a>
			<a href="index.html#top">6</a>
			<a href="index.html#top">7</a>
			<a href="index.html#top">20</a>
			<div class="previous"></div>
		</nav>			
	</article>
	<article class="right">
		<form action="#" method="get" class="search" accept-charset="utf-8">
			<input type="text" name="content">
			<button type="submit">搜索</button>
		</form>
		<nav>
			<header>管理</header>
			<ul>
				<c:choose>				
				
				<c:when test="${user!=null }">
					<li>欢迎:${user.account }</li>
					<li><a href="pages/manager.jsp">用户管理</a></li>
					<li><a href="pages/manager.jsp#content/order/order.jsp">订单管理</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="pages/login_register.jsp">登录注册</a></li>
				</c:otherwise>
				</c:choose>
			</ul>
		</nav>
		<section>
			<header>购物车</header>
			<ul>
				<c:forEach items="${cart.items }" var="item">
				<li>${item.book.name }
					<ul>
						<li>编号:${item.book.id }</li>
						<li>数量:${item.quantity }</li>
						<li>小计:<f:formatNumber type="currency">${item.total }</f:formatNumber></li>
						<li class="operator"><a href="do/cart?id=${item.book.id }&op=remove">删除</a></li>
					</ul>
				</li>
				</c:forEach>
			</ul>
			<footer>
				合计:<f:formatNumber type="currency">${cart.total }</f:formatNumber>
				<button onclick="document.location.href='pages/manager.jsp#content/order/cart.jsp'">
					提交
				</button>
			</footer>
		</section>
	</article>
</body>
</html>













