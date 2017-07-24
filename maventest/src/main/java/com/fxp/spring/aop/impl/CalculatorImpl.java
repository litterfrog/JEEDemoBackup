package com.fxp.spring.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class CalculatorImpl implements ICalculator {

	public int add(int i, int j) {
		int result = i+j;
		return result;
	}
	public int sub(int i,int j){
		int result = i-j;
		return result;
	}

}
