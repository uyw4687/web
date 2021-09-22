package config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/view/",".jsp");
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/main").setViewName("main");
		registry.addViewController("/survey").setViewName("survey");
	}
	
	@Bean
	public MessageSource messageSource() {
		ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
		ms.setBasenames("message.label", "message.error");
		ms.setDefaultEncoding("UTF-8");
		return ms;
	}
	
//	@Override
//	public Validator getValidator() {
//		return new RegisterValidator();
//	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				HttpSession session = request.getSession(false);
				if (session==null || session.getAttribute("authInfo")==null) {
					response.sendRedirect(request.getContextPath() + "/main");
					return false;
				}
				return true;
			}
		}).addPathPatterns("/chgPass", "/search");
	}
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'local'");
		ObjectMapper mapper = Jackson2ObjectMapperBuilder
								.json()
//								.featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS)
								.simpleDateFormat("yyyy-MM-dd HH:mm")
								.serializerByType(LocalDateTime.class, new LocalDateTimeSerializer(format))
								.deserializerByType(LocalDateTime.class, new LocalDateTimeDeserializer(format))
								.build();
		converters.add(0, new MappingJackson2HttpMessageConverter(mapper));
	}
	
//	@Autowired
//	private ApplicationContext applicationContext;
//	
//	@Bean
//	public SpringResourceTemplateResolver templateResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		templateResolver.setApplicationContext(applicationContext);
//		templateResolver.setPrefix("/WEB-INF/view/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setCacheable(false);
//		return templateResolver;
//	}
//	
//	@Bean
//	public SpringTemplateEngine templateEngine() {
//		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//		templateEngine.setTemplateResolver(templateResolver());
//		templateEngine.setEnableSpringELCompiler(true);
//		templateEngine.addDialect(new Java8TimeDialect());
//		return templateEngine;
//	}
//	
//	@Bean
//	public ThymeleafViewResolver thymeleafViewResolver() {
//		ThymeleafViewResolver resolver = new ThymeleafViewResolver();
//		resolver.setContentType("text/html");
//		resolver.setCharacterEncoding("UTF-8");
//		resolver.setTemplateEngine(templateEngine());
//		return resolver;
//	}
//	
//	@Override
//	public void configureViewResolvers(ViewResolverRegistry registry) {
//		registry.viewResolver(thymeleafViewResolver());
//	}
	
}
