package com.bingo.aop.impl;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import javax.naming.spi.DirStateFactory.Result;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class SecondLoggingAspect {
	/*//前置通知
	@Before("execution(public * com.bingo.aop.impl.RealArithmeticSubject.*(int,int))")
	public void before(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> list = Arrays.asList(joinPoint.getArgs());
		System.out.println("Before:the " + methodName +" method begins with" +list);
	}
	//后置通知 目标方法执行后 无论是否发生异常
	//还无法访问执行结果
	@After("execution(public * com.bingo.aop.impl.RealArithmeticSubject.*(int,int))")
	public void after(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> list = Arrays.asList(joinPoint.getArgs());
		System.out.println("After:the " + methodName +" method ends with" +list);
	}
	
	//返回通知
	@AfterReturning(value = "execution(public int com.bingo.aop.impl.RealArithmeticSubject.*(int,int))",returning="result")
	public void afterReturning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("AfterReturning : the result is " + result);
	}
	
	@AfterThrowing(value = "execution(public int com.bingo.aop.impl.RealArithmeticSubject.*(int,int))",throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("AfterThrowing:the " + methodName +" method occurs " +ex);

	}
	*/
	@Around("execution(public * com.bingo.aop.impl.RealArithmeticSubject.*(int,int))")
	public Object around(ProceedingJoinPoint pdj){
		String methodName = pdj.getSignature().getName();
		List<Object> list = Arrays.asList(pdj.getArgs());
		Object result = null;
		try {
			//前置
			System.out.println("2AroundBefore:the " + methodName +" method begins with" +list);
			//返回通知
			result = pdj.proceed();
			System.out.println("2AfterReturning : the result is " + result);
		}catch (Throwable e) {
			//异常通知
			System.out.println("2the method "+methodName+" occurs " + e);
            throw new RuntimeException(e);
		}
		//后置
		System.out.println("2After:the " + methodName +" method ends with" +list);
		return result;
	}
	
}
