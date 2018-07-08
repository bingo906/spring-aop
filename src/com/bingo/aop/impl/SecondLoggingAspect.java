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
	/*//ǰ��֪ͨ
	@Before("execution(public * com.bingo.aop.impl.RealArithmeticSubject.*(int,int))")
	public void before(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> list = Arrays.asList(joinPoint.getArgs());
		System.out.println("Before:the " + methodName +" method begins with" +list);
	}
	//����֪ͨ Ŀ�귽��ִ�к� �����Ƿ����쳣
	//���޷�����ִ�н��
	@After("execution(public * com.bingo.aop.impl.RealArithmeticSubject.*(int,int))")
	public void after(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		List<Object> list = Arrays.asList(joinPoint.getArgs());
		System.out.println("After:the " + methodName +" method ends with" +list);
	}
	
	//����֪ͨ
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
			//ǰ��
			System.out.println("2AroundBefore:the " + methodName +" method begins with" +list);
			//����֪ͨ
			result = pdj.proceed();
			System.out.println("2AfterReturning : the result is " + result);
		}catch (Throwable e) {
			//�쳣֪ͨ
			System.out.println("2the method "+methodName+" occurs " + e);
            throw new RuntimeException(e);
		}
		//����
		System.out.println("2After:the " + methodName +" method ends with" +list);
		return result;
	}
	
}
