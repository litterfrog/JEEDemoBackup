package com.fxp.bookstore.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fxp.bookstore.model.entity.Account;
import com.fxp.bookstore.model.service.ServiceFactory;
@WebServlet("/do/user")
public class UserServlet extends HttpServlet {
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("op");
		String name = req.getParameter("name").trim();
		String password = req.getParameter("password").trim();		
		Account account = new Account();
		account.setAccount(name);
		account.setPassword(password);
		//do register
		List<Account> list;
		if("register".equals(op)){
			String confirm = req.getParameter("confirm").trim();
			String email = req.getParameter("email").trim();
			account.setEmail(email);
			if("".equals(name)){
				req.setAttribute("name_err", "用户名不能为空");
				forward(req, resp,"/pages/login_register.jsp");
				return;
			}
			list=ServiceFactory.getService("user").findByConditions(name);
			if(!list.isEmpty()){
				req.setAttribute("name_err", "用户名已存在");
				forward(req, resp,"/pages/login_register.jsp");
				return;
			}
			int row=ServiceFactory.getService("user").save(account);
			if(row>0){
				 list = ServiceFactory.getService("user").findByConditions(account.getAccount());
			}
			req.getSession().setAttribute("user", list.get(0));
			resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
			
		}else if("login".equals(op)){
			list =ServiceFactory.getService("user").findByConditions(name);
			if(list.isEmpty()||!list.get(0).getPassword().equals(account.getPassword())){
				req.setAttribute("login_err", "用户名或密码错误");
				forward(req, resp, "/pages/login_register.jsp");
				return;
			}
			req.getSession().setAttribute("user", list.get(0));
			resp.sendRedirect(getServletContext().getContextPath()+"/index.jsp");
		}

		
	}

	private void forward(HttpServletRequest req, HttpServletResponse resp,String url) throws ServletException, IOException {
		getServletContext().getRequestDispatcher(url).forward(req, resp);
	}
}
