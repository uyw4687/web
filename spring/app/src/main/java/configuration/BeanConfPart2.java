package configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import spring.CountPrinter;
import spring.MemberDao;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberPrinter;
import spring.VersionPrinter;

@Configuration
public class BeanConfPart2 {
	
	@Autowired
	BeanConfPart1 conf1;

	@Autowired
	MemberDao memberDao;
	
	@Bean
	public MemberPrinter memPrinter() {
		return new MemberPrinter();
	}

	@Bean
	public MemberListPrinter memListPrinter(MemberPrinter memPrinter) {
		return new MemberListPrinter(conf1.memberDao(), memPrinter);
	}

	@Bean
	public MemberInfoPrinter memInfoPrinter() {
		MemberInfoPrinter printer = new MemberInfoPrinter();
		printer.setDao(memberDao);
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
