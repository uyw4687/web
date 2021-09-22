package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import lifecycle.LifeCycle;

@Configuration
public class CycleScopeConfig {

	@Bean(initMethod = "customStart", destroyMethod = "customDestroy")
	@Scope("prototype")
	public LifeCycle lifeCycle() {
		LifeCycle lifeCycle = new LifeCycle();
		lifeCycle.setHost("EFE");
		return lifeCycle;
	}

}