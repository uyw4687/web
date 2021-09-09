package proc;

import java.sql.ResultSet;

import dao.MemberDAO;
import data.Member;

public class Processor {

	public boolean add(Member newMember) {
		
		return new MemberDAO().insert(newMember);
		
	}
	
	public boolean remove(String id) {
		
		return new MemberDAO().remove(id);
		
	}
	
	public Member search(String id) {
		
		return new MemberDAO().search(id);
		
	}

	public boolean change(Member member) {

		return new MemberDAO().change(member);
		
	}

}
