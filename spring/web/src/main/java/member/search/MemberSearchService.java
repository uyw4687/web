package member.search;

import java.time.LocalDateTime;
import java.util.List;

import member.Member;
import member.MemberDao;

public class MemberSearchService {
	
	private MemberDao dao;
	
	public MemberSearchService(MemberDao dao) {
		this.dao = dao;
	}

	public List<Member> searchInterval(LocalDateTime from, LocalDateTime to) {
		return dao.searchInterval(from, to);
	}

	public Member getMemberById(long id) {
		return dao.getMemberById(id);
	}
	
	public List<Member> list() {
		return dao.selectAll();
	}
	
}