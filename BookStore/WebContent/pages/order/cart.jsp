<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/BookStore/" target="_parent"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cart</title>
</head>
<f:setLocale value="${pageContext.request.locale }"/>
<body>
	<header>提交订单</header>
	<section>
		<header>购物车信息</header>
		<ul class="caption">
			<li class="id">编号</li>
			<li class="name">名称</li>
			<li class="price">单价</li>
			<li class="quantity">数量(本)</li>
			<li class="total">小计</li>
			<li class="operator">操作</li>
		</ul>
		<c:forEach items="${cart.items }" var="item">
		<ul class="odd">
			<li class="id">${item.book.id }</li>
			<li class="name">${item.book.name }</li>
			<li class="price">
				<f:formatNumber type="currency" value="${item.book.sellingPrice }"></f:formatNumber>
			</li>
			<li class="quantity">${item.quantity }</li>
			<li class="total">
				<f:formatNumber type="currency" value="${item.total }"></f:formatNumber>
			</li>
			<li class="operator"><a href="">删除</a></li>
		</ul>
		</c:forEach>
		<footer>合计:
			<f:formatNumber type="currency" value="${cart.total }"></f:formatNumber>
		</footer>
	</section>
	<section>
		<header>收货人信息</header>
		<ul class="caption">
			<li class="check">选择</li>
			<li class="id">编号</li>
			<li class="full_name">姓名</li>
			<li class="tel">电话</li>
			<li class="operator">操作</li>
		</ul>
		<form action="do/order" id="submit_order" method="post">
		<c:forEach items="${user.consignees }" var="consignee">
			<ul class="odd">
				<li class="check"><input value="${consignee.id }" type="radio" name="consigneeId"></li>
				<li class="id">${consignee.id }</li>
				<li class="full_name">${consignee.fullName }</li>
				<li class="tel">${consignee.tel }</li>
				<li class="operator"><a href="">删除</a></li>
				<section>
					<li class="address">地址:${consignee.address }</li>
				</section>			
			</ul>
		</c:forEach>
		</form>
		<form action="do/consignee" method="post">
		<ul class="add">
			<li class="real_name">姓名:<input type="text" name="name"/></li>
			<li class="tel">联系电话:<input type="text" name="tel"/></li>
			<li class="province">省/直辖市:
				<input name="province" list="province_list"/>
				<datalist id="province_list">
					<option value="上海市"/>
					<option value="北京市"/>
					<option value="黑龙江省"/>
				</datalist>
			</li>
			<li class="city">区/县/市:
				<input name="city" list="city_list"/>
				<datalist id="city_list">
					<option value="虎林市"/>
					<option value="哈尔滨市"/>
				</datalist>
			</li>
		</ul>
		<ul class="add">
			<li class="streat">街道/详细地址:<input name="street"/></li>
			<li class="operator"><button type="submit">添加</button></li>
		</ul>
		</form>
	</section>
	<footer><button onclick="document.getElementById('submit_order').submit()">提交订单</button><c:if test="${order_err!=null }"><strong style="color:#f00">${order_err }</strong></c:if></footer>
</body>
</html>