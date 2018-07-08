package com.bingo.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArithmeticSubject arithmeticSubject =  ctx.getBean(ArithmeticSubject.class);
		arithmeticSubject.divide(2, 1);
		//arithmeticSubject.times(1, 2);
	}
}
