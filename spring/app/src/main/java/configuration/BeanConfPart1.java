package configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.ChangePasswordService;
import spring.MemberDao;
import spring.MemberRegisterService;

@Configuration
@Import({BeanConfPart2.class})
//@ImportResource({"classpath:confPart2.xml"})
@EnableTransactionManagement
public class BeanConfPart1 {

	@Bean
	public DataSource dataSource() {
		DataSource dataSource = new DataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/spring4fs?characterEncoding=utf8");
		dataSource.setUsername("spring4");
		dataSource.setPassword("spring4");
		dataSource.setMaxActive(10);
		dataSource.setTestWhileIdle(true);
		dataSource.setMinEvictableIdleTimeMillis(3*60*1000);
		dataSource.setTimeBetweenEvictionRunsMillis(10*1000);
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager dataSourceTransactionManager() {
		DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
		dataSourceTransactionManager.setDataSource(dataSource());
		return dataSourceTransactionManager;
	}
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

	@Bean
	public MemberRegisterService memRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public ChangePasswordService chgPwdSvc() {
		return new ChangePasswordService(memberDao());
	}
	
}
