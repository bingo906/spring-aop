package com.bingo.proxy;

import java.lang.reflect.Proxy;

import javax.security.auth.Subject;

public class MainTest {
	public static void main(String[] args) {
		RealArithmeticSubject realArithmeticSubject = new RealArithmeticSubject();
		MyHandler myHandler = new MyHandler();
		myHandler.setRealArithmeticSubject(realArithmeticSubject);
		
		ArithmeticSubject proxySubject  =  (ArithmeticSubject) Proxy.newProxyInstance(RealArithmeticSubject.class.getClassLoader(),
				realArithmeticSubject.getClass().getInterfaces(), myHandler);
		proxySubject.plus(5, 6);
		proxySubject.minus(5, 6);
		proxySubject.times(-5, 7);
		proxySubject.divide(10, 2);
			
	}
}
