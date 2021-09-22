package config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import member.MemberDao;
import member.auth.LoginService;
import member.auth.chgPass.ChangePasswordService;
import member.register.MemberRegisterService;
import member.search.MemberSearchService;

@Configuration
public class MemberConfig {

	@Configuration
	@Profile("dev")
	public static class DataSourceDev {
		@Bean
		public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			
			ds.setUrl("jdbc:mysql://localhost/spring4fs?characterEncoding=utf8");
			ds.setUsername("spring4");
			ds.setPassword("spring4");
			
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
			ds.setTimeBetweenEvictionRunsMillis(1000 * 10);
			
			return ds;
		}
	}
	
	@Configuration
	@Profile("!dev")
	public static class DataSourceDist {
		@Bean
		public DataSource dataSource() {
			DataSource ds = new DataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			
			ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8");
			ds.setUsername("spring5");
			ds.setPassword("spring5");
			
			ds.setInitialSize(2);
			ds.setMaxActive(10);
			
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(1000 * 60 * 3);
			ds.setTimeBetweenEvictionRunsMillis(1000 * 10);
			
			return ds;
		}
	}
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	public MemberDao dao() {
		return new MemberDao(dataSource);
	}
	
	@Bean
	public MemberRegisterService regSvc() {
		return new MemberRegisterService(dao());
	}
	
	@Bean
	public LoginService loginSvc() {
		return new LoginService(dao());
	}

	@Bean
	public ChangePasswordService chgPwdSvc() {
		return new ChangePasswordService(dao());
	}

	@Bean
	public MemberSearchService searchSvc() {
		return new MemberSearchService(dao());
	}
	
}
