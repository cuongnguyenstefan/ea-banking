package edu.mum.ea.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class ServiceAdvice {
	
	private final Logger logger = LoggerFactory.getLogger(ServiceAdvice.class); 

	@Around("execution(* edu.mum.ea.service..*.*(..))")
	public Object serviceLogging(ProceedingJoinPoint joinPoint) throws Throwable {
		logger.info("Starting service: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName());
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		Object proceed = joinPoint.proceed();
		stopWatch.stop();
		logger.info("Finishied running service: " + joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + ", took: " + stopWatch.getTotalTimeMillis() +" ms");
		return proceed;
	}
	
}
