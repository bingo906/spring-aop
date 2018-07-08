package com.bingo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MyHandler implements InvocationHandler{
	private RealArithmeticSubject realArithmeticSubject;
	
	public void setRealArithmeticSubject(RealArithmeticSubject realArithmeticSubject) {
		this.realArithmeticSubject = realArithmeticSubject;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		Object result = null;
		boolean flag = chechNum(Integer.parseInt(args[0].toString()), Integer.parseInt(args[1].toString()));
		//增加验证功能
		if(flag){
			//模拟Aop 增加日志功能
			System.out.println("The operation is " + method.getName());
			result = method.invoke(realArithmeticSubject, args);	
			System.out.println("The operation " + method.getName() + " is finished! ");
			System.out.println("\n");
		}else{
			System.out.println(method.getName()+"方法参数错误\n");
		}
		return result;
	}
	
	//模拟增加验证功能
	public boolean chechNum(int i,int j){
		//只对正数进行运算
		if( i<0 || j<0 ){
			System.out.println("只能进行正数运算");
			return false;
		}
		return true;
	}
}
