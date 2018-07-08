package com.bingo.aop.impl;

import org.springframework.stereotype.Component;

@Component
public class RealArithmeticSubject implements ArithmeticSubject{

	@Override
	public int plus(int i, int j) {
		System.out.println(i +" plus "+ j +" = " + (i+j));
		return i+j;
	}

	@Override
	public int minus(int i, int j) {
		System.out.println(i +" minus "+ j +" = " + (i-j));
		return i-j;
	}

	@Override
	public int times(int i, int j) {
		System.out.println(i +" tiems "+ j +" = " + (i*j));
		return i*j;
	}

	@Override
	public int divide(int i, int j) {
		System.out.println(i +" divided "+ j +" = " + (i/j));
		return i/j;
	}
	
}
