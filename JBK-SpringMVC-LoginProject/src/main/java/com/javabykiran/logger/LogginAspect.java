package com.javabykiran.logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LogginAspect {
	
	
	@Before("execution(* com.javabykiran.controller.*.*(..))")
	//@Before("execution(* com.javabykiran.controller.LoginController.*(..))")
	public void BeforeLoginController(JoinPoint joinpoint) {
		System.out.println("Entering in Controller:  " + joinpoint.getSignature().getName());
		System.out.println("User Login time: " + new java.util.Date());
		System.out.println("********************************************************");

	}

	@After("execution(* com.javabykiran.controller.*.*(..))")
	//@After("execution(* com.javabykiran.controller.LoginController.*(..))")
	public void AfterLoginController(JoinPoint joinpoint) {
		System.out.println("Exiting  from Controller:  " + joinpoint.getSignature().getName());
		System.out.println("User Logout time: " + new java.util.Date());
		System.out.println("********************************************************");

	}
	
	
	@Before("execution(* com.javabykiran.dao.*.*(..))")
	public void BeforeLoginDao(JoinPoint joinpoint) {
		System.out.println("Entering Before  Dao:  " + joinpoint.getSignature().getName());
		System.out.println("User Login Dao time: " + new java.util.Date());
		System.out.println("********************************************************");

	}

	@After("execution(* com.javabykiran.dao.*.*(..))")
	public void AfterLoginDao(JoinPoint joinpoint) {
		System.out.println("Exiting from  Dao:  " + joinpoint.getSignature().getName());
		System.out.println("User Logout Dao time: " + new java.util.Date());
		System.out.println("********************************************************");

	}
	

	@Before("execution(* com.javabykiran.service.*.*(..))")
	public void BeforeService(JoinPoint joinpoint) {
		System.out.println("Entering Before  Service:  " + joinpoint.getSignature().getName());
		System.out.println("User Login Service time: " + new java.util.Date());
		System.out.println("********************************************************");

	}

	@After("execution(* com.javabykiran.service.*.*(..))")
	public void AfterService(JoinPoint joinpoint) {
		System.out.println("Exiting from  Service:  " + joinpoint.getSignature().getName());
		System.out.println("User Logout Service time: " + new java.util.Date());
		System.out.println("********************************************************");

	}
}

	
	
	

	
	
	
	
	
