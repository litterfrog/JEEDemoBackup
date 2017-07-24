package com.fxp.bookstore.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxp.bookstore.model.entity.Account;
import com.fxp.bookstore.model.entity.Consignee;
import com.fxp.bookstore.model.service.ServiceFactory;
@WebServlet("/do/consignee")
public class ConsigneeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name=req.getParameter("name");
		String tel=req.getParameter("tel");
		String province=req.getParameter("province");
		String city=req.getParameter("city");
		String street=req.getParameter("street");
		String address=province.trim()+" "+city.trim()+" "+street.trim();
		Consignee csn=new Consignee();
		csn.setFullName(name);
		csn.setTel(tel);
		csn.setAddress(address);
		Account account=(Account) req.getSession().getAttribute("user");
		System.out.println(account.toString());
		csn.setAccountId(account.getId());
		System.out.println(csn.toString());
		int row;
		try {
			row = ServiceFactory.getService("consignee").save(csn);
			if(row>0){
				List<Consignee> consignees = ServiceFactory.getService("consignee").findByConditions(csn.getAccountId()+"");
				account.setConsignees(consignees);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		req.setAttribute("manager_page", "order/cart.jsp");
		getServletContext().getRequestDispatcher("/pages/manager.jsp").forward(req, resp);
	}
}
