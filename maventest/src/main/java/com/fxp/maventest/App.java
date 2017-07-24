package com.fxp.maventest;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fxp.spring.aop.impl.ICalculator;

/**
 * Hello world!
 *
 */

public class App 
{
    public static void main( String[] args )
    {
		//1创建spring 的 IOC容器
		ApplicationContext ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
		//2从IOC容器中获取bean
		ICalculator calculator=ctx.getBean(ICalculator.class);
		//3使用
		int add = calculator.add(1, 2);
		int sub = calculator.sub(2,3);
		System.out.println("result"+add+" sub:"+sub);
    }
}
