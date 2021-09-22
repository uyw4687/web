package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import lifecycle.LifeCycle;

public class LifeMain {

	public static void main(String[] args) {
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:lifeBean.xml");
		
		AnnotationConfigApplicationContext ctx = 
				new AnnotationConfigApplicationContext(configuration.CycleScopeConfig.class);
		
		LifeCycle lifeCycle = ctx.getBean("lifeCycle", LifeCycle.class);
		LifeCycle lifeCycle2 = ctx.getBean("lifeCycle", LifeCycle.class);
		
		System.out.println(lifeCycle==lifeCycle2);
		
		lifeCycle.whoami();
		ctx.close();

	}

}
