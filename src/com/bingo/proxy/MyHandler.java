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
		//������֤����
		if(flag){
			//ģ��Aop ������־����
			System.out.println("The operation is " + method.getName());
			result = method.invoke(realArithmeticSubject, args);	
			System.out.println("The operation " + method.getName() + " is finished! ");
			System.out.println("\n");
		}else{
			System.out.println(method.getName()+"������������\n");
		}
		return result;
	}
	
	//ģ��������֤����
	public boolean chechNum(int i,int j){
		//ֻ��������������
		if( i<0 || j<0 ){
			System.out.println("ֻ�ܽ�����������");
			return false;
		}
		return true;
	}
}
