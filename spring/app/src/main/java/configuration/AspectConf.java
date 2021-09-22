package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import aspect.CacheAspect;
import aspect.TimeMeasure;
import calculator.ImpeCalculator;
import calculator.RecCalculator;

@Configuration
//@EnableAspectJAutoProxy()
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class AspectConf {

	@Bean
	public TimeMeasure timeMeasure() {
		return new TimeMeasure();
	}
	
	@Bean
	public CacheAspect cacheAspect() {
		return new CacheAspect();
	}
	
	@Bean
	public ImpeCalculator impeCal() {
		return new ImpeCalculator();
	}

	@Bean
	public RecCalculator recCal() {
		return new RecCalculator();
	}
	
}
