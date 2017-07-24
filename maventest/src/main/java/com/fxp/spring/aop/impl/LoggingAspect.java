package com.fxp.spring.aop.impl;

import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//把一个类声明为一个切面：需要把该类放入到IOC容器中、再声明为一个切面
@Aspect
@Component
public class LoggingAspect {
	//声明该方法是一个前置通知：在目标方法开始之前执行
	@Before("execution(public * com.fxp.spring.aop.*.*.*(..))")
	public void beforeMethod(JoinPoint joinpoint){
		String methodName=joinpoint.getSignature().getName();
		List<Object> args = Arrays.asList(joinpoint.getArgs());
		System.out.println("The Method "+methodName+" begins with "+args);
	}
}
