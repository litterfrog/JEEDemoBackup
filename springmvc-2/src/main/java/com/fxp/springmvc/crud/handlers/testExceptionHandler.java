package com.fxp.springmvc.crud.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class testExceptionHandler {
	/**
	 * 1.在@ExceptionHandler方法的入参中可以加入Exception类型的参数，该参数即对应发生的异常对象
	 * 2.@ExceptionHandler方法的的入参中不能传入Map，若希望把异常信息传导到页面上，需要使用ModelAndView作为返回值。
	 * 3.@ExceptionHandler方法标记的异常有优先级的问题。更接近的异常优先
	 * @param ex
	 * @return
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException(Exception ex){
		System.out.println("出异常了HandleException："+ex);
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("exception",ex);
		return mv;
	}
}
