package com.bingo.proxy;

public class RealArithmeticSubject implements ArithmeticSubject{

	@Override
	public void plus(int i, int j) {
		System.out.println(i +" plus "+ j +" = " + (i+j));
	}

	@Override
	public void minus(int i, int j) {
		System.out.println(i +" minus "+ j +" = " + (i-j));
	}

	@Override
	public void times(int i, int j) {
		System.out.println(i +" tiems "+ j +" = " + (i*j));
	}

	@Override
	public void divide(int i, int j) {
		System.out.println(i +" divided "+ j +" = " + (i/j));
	}
	
}
