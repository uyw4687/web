package spring;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MemberListPrinter {

	MemberDao dao;
	MemberPrinter printer;
	
////	public MemberListPrinter() {
////	}
//
////	@Autowired(required=false)
//	@Autowired
	public MemberListPrinter( @Qualifier("memberDao") MemberDao dao, MemberPrinter printer) {
//		System.out.println(dao);
		this.dao = dao;
		this.printer = printer;
	}
	
	public void printMembers() {
		
		Collection<Member> list = dao.selectAll();
		
		for(Member m: list) {
			printer.print(m);
		}
		
	}
	
}
