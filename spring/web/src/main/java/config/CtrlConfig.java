
package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import control.CustomRestExceptionHandler;
import member.auth.AuthController;
import member.auth.LoginService;
import member.auth.chgPass.ChangePasswordService;
import member.auth.chgPass.ChgPassController;
import member.register.JoinController;
import member.register.MemberRegisterService;
import member.register.rest.JoinRestController;
import member.search.MemberSearchService;
import member.search.SearchController;
import member.search.rest.SearchRestController;
import survey.SurveyController;
import survey.rest.GetDateRestController;
import version.Version;
import version.rest.VersionRestController;

@Configuration
public class CtrlConfig {
	
	@Autowired
	MemberRegisterService regSvc;
	@Autowired
	LoginService loginSvc;
	@Autowired
	ChangePasswordService pwdSvc;
	@Autowired
	MemberSearchService searchSvc;

	@Bean
	public JoinController joinController() {
		return new JoinController(regSvc);
	}

	@Bean
	public JoinRestController joinRestController() {
		return new JoinRestController(regSvc);
	}

	@Bean
	public SurveyController surveyContrlloer() {
		return new SurveyController();
	}

	@Bean
	public AuthController loginContrlloer() {
		return new AuthController(loginSvc);
	}

	@Bean
	public ChgPassController chgPassController() {
		return new ChgPassController(pwdSvc);
	}

	@Bean
	public SearchController searchController() {
		return new SearchController(searchSvc);
	}

	@Bean
	public SearchRestController searchRestController() {
		return new SearchRestController(searchSvc);
	}

	@Bean
	public GetDateRestController getDateRestController() {
		return new GetDateRestController();
	}
	
//	@Bean
//	public CustomExceptionHandler custExceptionHandler() {
//		return new CustomExceptionHandler();
//	}

	@Bean
	public CustomRestExceptionHandler custRestExceptionHandler() {
		return new CustomRestExceptionHandler();
	}
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer properties() {
		PropertySourcesPlaceholderConfigurer props = new PropertySourcesPlaceholderConfigurer();
		props.setLocations(new ClassPathResource("version.properties"));
		return props;
	}

	@Bean
	public Version ver() {
		return new Version();
	}
	
	@Bean
	public VersionRestController verController() {
		return new VersionRestController(ver());
	}
	
}
