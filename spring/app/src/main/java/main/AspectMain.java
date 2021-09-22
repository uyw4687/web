package main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import calculator.Calculator;
import calculator.ImpeCalculator;
import configuration.AspectConf;

public class AspectMain {

	public static void main(String[] args) {
		
//		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:Aspect.xml");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AspectConf.class);
		
		Calculator cal = ctx.getBean("impeCal", ImpeCalculator.class);
		System.out.println(cal.factorial(20)+"\n");
		cal = ctx.getBean("recCal", Calculator.class);
		System.out.println(cal.factorial(20));
		
		ctx.close();

	}

}
