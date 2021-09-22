package configuration;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import spring.ChangePasswordService;
import spring.CountPrinter;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberRegisterService;
import spring.VersionPrinter;

@Configuration
@ComponentScan(basePackages = "spring")//, excludeFilters = @Filter(type = FilterType.REGEX, pattern = "spring\\..*ListPrinter"))
@EnableTransactionManagement
public class BeanConfiguration {

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

//	@Bean
//	public MemberPrinter memPrinter() {
//		return new MemberPrinter();
//	}

//	@Bean
//	public MemberListPrinter memListPrinter(MemberDao memberDao, MemberPrinter memPrinter) {
//		return new MemberListPrinter(memberDao, memPrinter);
//	}

	@Bean
	public MemberInfoPrinter memInfoPrinter() {
		MemberInfoPrinter printer = new MemberInfoPrinter();
//		printer.setDao(memberDao());
//		printer.setPrinter(memPrinter());
		return printer;
	}

	@Bean
	public VersionPrinter verPrinter() {
		VersionPrinter printer = new VersionPrinter();
		printer.setMajorVersion(2);
		printer.setMinorVersion(3);
		return printer;
	}
	
	@Bean
	public CountPrinter cntPrinter() {
		return new CountPrinter();
	}
	
}
