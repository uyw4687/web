package spring;

import org.springframework.beans.factory.annotation.Autowired;

public class CountPrinter {

	@Autowired
	private MemberDao dao;

//	private NoBean nb;

	public CountPrinter(MemberDao dao) {
		this.dao = dao;
	}
	
	public CountPrinter() {
	}
	
	public void setMemberDao(MemberDao dao) {
		this.dao = dao;
	}

	@Autowired(required = false)
	public void setNoBean(NoBean nb) {
		System.out.println("executed1");
	}
	
//	@Autowired
//	public void setNoBean2(Optional<NoBean> nb) {
//		System.out.println("executed2");
//	}
//	
//	@Autowired
//	public void setNoBean3(@Nullable NoBean nb) {
//		System.out.println("executed3");
//	}
	
	public void print() { 
		System.out.println("total : " + dao.count());
	}
	
}
