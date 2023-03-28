package com.ecommerce.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EShopAspect {
	private Logger logger = Logger.getLogger(getClass().getName());

	@Pointcut("execution(* com.ecommerce.service.*.*(..))")
	public void serviceCalls() {
		logger.info("Service Package Called");

	}

	@Pointcut("serviceCalls()")
	public void appCalls() {
	}

	@AfterThrowing("serviceCalls()")
	public void rollbackTransaction() {
		logger.info("Transaction roll back");
	}

	@Before("appCalls()")
	public void before(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().toShortString();

		logger.info("Method Called: " + methodName);
		Object[] args = joinPoint.getArgs();

		for (Object arg : args) {
			logger.info("Argument : " + arg);
		}
	}

}
