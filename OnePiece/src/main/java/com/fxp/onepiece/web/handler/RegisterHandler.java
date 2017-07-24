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

import com.fxp.onepiece.model.entity.User;
import com.fxp.onepiece.model.service.ICommonService;
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/register")
public class RegisterHandler {
	@SuppressWarnings("rawtypes")
	@Autowired
	@Qualifier("userServiceImpl")
	private ICommonService userServiceImpl;
	
	public RegisterHandler() {
		System.out.println("CommonHandler constructor...");
	}
	/**
	 * ת��ע���ҳ��
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/doRegister",method=RequestMethod.GET)
	public String doRegister(Map<String,Object> map){
		map.put("user", new User());
		return "register";
	}
	/**
	 * �����ҳ����ajax������֤�û����Ƿ����
	 * @param name
	 * @param res
	 * @throws IOException
	 */
	@RequestMapping(value="/checkUserName",method=RequestMethod.POST)
	public void checkUserName(@RequestParam("name")String name,HttpServletResponse res) throws IOException{
		
		System.out.println("name:"+name);
		Object user = userServiceImpl.getByName(name);
		System.out.println("user:"+user);
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html");		
		if(user==null){
			//��ʾ����
			res.getWriter().write("1");
		}else{
			res.getWriter().write("0");
		}
	}
	/**
	 * ��Ϣ�ύ���б��棬ͬʱ�������ݵ���֤JSR303
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/saveUser",method=RequestMethod.POST)
	public String saveUser(@Valid User user,BindingResult result){
		if(result.getErrorCount()>0){
			System.out.println("save������"+result.getErrorCount());
			for(FieldError error:result.getFieldErrors()){
				System.out.println(error.getField()+":"+error.getDefaultMessage());
			}
			return "register";
		}
		user.setCreateTime(new Date());
		System.out.println("userServiceImpl"+userServiceImpl);
		userServiceImpl.saveOrUpdate(user);
		System.out.println(user);
		return "success";
	}
}
