package com.fxp.onepiece.web.handler;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.fxp.onepiece.model.entity.User;
import com.fxp.onepiece.model.service.ICommonService;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/login")
@SessionAttributes(value={"loggedInUser"})
public class LoginHandler {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("userServiceImpl")
	private ICommonService userServiceImpl;
	
	public LoginHandler() {
		System.out.println("LoginHandler constructor...");
	}
	/**
	 * 转到登录表单页面
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/doLogin",method=RequestMethod.GET)
	public String doLogin(Map<String,Object> map){
		map.put("user", new User());
		return "login";
	}
	@RequestMapping(value="/getUser",method=RequestMethod.POST)
	public String getUser(User user,Map<String,Object> map){
		if(user==null||user.getName()==null||user.getName().trim()==""){
			return "error";
		}
		User userByName = (User) userServiceImpl.getByName(user.getName());
		if(userByName==null){
			return "error";
		}
		if(userByName.getPassword().trim().equals(user.getPassword().trim())){
			//把user放到session中
			map.put("loggedInUser", userByName);
			System.out.println("login ok");
			return "success";
		}
		
		return "success";
	}
}
