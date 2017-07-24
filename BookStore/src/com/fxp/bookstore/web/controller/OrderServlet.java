package com.fxp.bookstore.web.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxp.bookstore.model.dao.DaoFactory;
import com.fxp.bookstore.model.entity.Account;
import com.fxp.bookstore.model.entity.CartItem;
import com.fxp.bookstore.model.entity.Consignee;
import com.fxp.bookstore.model.entity.Order;
import com.fxp.bookstore.model.entity.OrderItem;
import com.fxp.bookstore.model.service.Cart;
import com.fxp.bookstore.model.service.ServiceFactory;

import sun.print.resources.serviceui_fr;
@WebServlet("/do/order")
public class OrderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cart cart=(Cart) req.getSession().getAttribute("cart");
		if(cart==null||cart.getItems().isEmpty()){
			req.setAttribute("order_err", "请选购图书");
			getServletContext().getRequestDispatcher("/pages/manager.jsp").forward(req, resp);
			return;
		}
		List<OrderItem> items=new ArrayList<>();
		for(CartItem item:cart.getItems()){
			OrderItem orderItem = new OrderItem();
			orderItem.setBookId(item.getBook().getId());
			orderItem.setQuantity(item.getQuantity());
			//在service里边添加orderId
			items.add(orderItem);
		}
		Order order=new Order();
		order.setConsignee(new Consignee());
		order.getConsignee().setId(Integer.parseInt(req.getParameter("consigneeId")));
		List<Order> orders;
		try {
			int id=ServiceFactory.getService("order").save(order);
			Account account=(Account) req.getSession().getAttribute("user");
			orders = ServiceFactory.getService("order").findByConditions(account.getId()+"");
			req.setAttribute("orders", orders);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("order");
		req.setAttribute("manager_page", "order/order.jsp");
		getServletContext().getRequestDispatcher("/pages/manager.jsp").forward(req, resp);
	}
}
