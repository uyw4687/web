package aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(1)
public class CacheAspect {

	Map<Long, Long> map = new HashMap<>(); 
	
	@Pointcut("execution(* calculator..*(..))")
	private void publicMethod() {
	}
	
	@Around("publicMethod()")
	public Object findStoreCache(ProceedingJoinPoint joinPoint) throws Throwable {
	
		try {

			System.out.println("start cache");
			Long arg = (Long)joinPoint.getArgs()[0];
			Object mapRet = map.get(arg);
			if (mapRet!=null) {
				return (long)mapRet;
			}
			
			long ret = (long)joinPoint.proceed();
			map.put(arg, ret);
			System.out.println(map.get(arg));
			return ret;
			
		} finally {
			System.out.println("end cache");
		}
		
	}
	
}
