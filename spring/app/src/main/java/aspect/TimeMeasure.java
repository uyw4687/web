package aspect;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(0)
public class TimeMeasure {
	
	@Pointcut("execution(* calculator..*(..))")
	public void publicMethod() {
	}
	
	@Around("publicMethod()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		
		System.out.println("started measure");
		long start = System.nanoTime();
		Object ret = joinPoint.proceed();
		long end = System.nanoTime();
				
		System.out.printf("%s %s (%s) %f ns\n", joinPoint.getTarget().getClass().getSimpleName(), 
				joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()), (double)(end-start)/1000);
		System.out.println("ended measure");
		
		return ret;
		
	}
	
}
