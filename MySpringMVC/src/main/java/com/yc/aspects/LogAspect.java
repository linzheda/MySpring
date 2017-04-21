package com.yc.aspects;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Before(value = "execution(* com.yc.biz.impl.StudentBizImpl.add(..))")
	public void log(   JoinPoint jp   ){
		System.out.println( "++++++++++++++++++++"  );
		System.out.println("时间:"+ new Date());
		System.out.println("添加的学生信息:");
		Object[] objs=jp.getArgs();
		System.out.println(  objs[0]);
		
		System.out.println("+++++++++++++++++++++");
	}
	
	@Pointcut("execution(* com.yc.biz.impl.StudentBizImpl.add(..))")// the pointcut expression
	private void anyOldTransfer() {}
	
	
}
