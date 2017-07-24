package com.fxp.springmvc.crud.handlers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class testExceptionHandler {
	/**
	 * 1.��@ExceptionHandler����������п��Լ���Exception���͵Ĳ������ò�������Ӧ�������쳣����
	 * 2.@ExceptionHandler�����ĵ�����в��ܴ���Map����ϣ�����쳣��Ϣ������ҳ���ϣ���Ҫʹ��ModelAndView��Ϊ����ֵ��
	 * 3.@ExceptionHandler������ǵ��쳣�����ȼ������⡣���ӽ����쳣����
	 * @param ex
	 * @return
	 */
	@ExceptionHandler({ArithmeticException.class})
	public ModelAndView handleArithmeticException(Exception ex){
		System.out.println("���쳣��HandleException��"+ex);
		ModelAndView mv=new ModelAndView("error");
		mv.addObject("exception",ex);
		return mv;
	}
}
