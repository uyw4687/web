package spring;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MemberInfoPrinter {

	@Autowired
	@Qualifier("memberDao")
	MemberDao dao;
	MemberPrinter printer;

	public void setDao(MemberDao dao) {
//		System.out.println(dao);
		this.dao = dao;
	}

//	@Autowired(required=false)
//	@Autowired
	@Resource(name="memPrinter")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}
	
	public void printInfo(String email) {
		
		Member member = dao.selectByEmail(email);
		if (member != null) {
			printer.print(member);
		}
		else {
			System.out.println("not found");
		}
		
	}
	
}
