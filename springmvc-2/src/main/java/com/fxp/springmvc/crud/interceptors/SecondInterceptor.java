package com.fxp.springmvc.crud.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class SecondInterceptor implements HandlerInterceptor {
	/**
	 * 该方法在目标方法之前调用，
	 * 若返回值为true，则继续调用后续的拦截器和目标方法
	 * 若返回false，则不会再调用后续的拦截器和目标方法
	 * 
	 * 
	 * 可以考虑做权限，日志，事务等。
	 * @param request
	 * @param response
	 * @param handler
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[SecondInterceptor]preHandle");
		return true;
	}
	/**
	 * 调用目标方法之后，渲染视图之前。
	 * 
	 * 可以对请求域中的属性或视图做出修改
	 * @param request
	 * @param response
	 * @param handler
	 * @param modelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[SecondInterceptor]postHandle");

	}
	/**
	 * 渲染视图之后调用
	 * 
	 * 可以释放资源
	 * @param request
	 * @param response
	 * @param handler
	 * @param ex
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[SecondInterceptor]afterCompletion");

	}

}
