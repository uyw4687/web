package member.auth;

import member.Member;
import member.MemberDao;

public class LoginService {

	private MemberDao dao;
	
	public LoginService(MemberDao dao) {
		this.dao = dao;
	}
	
	public Member login(String username, String password) {
		Member member = dao.selectByEmail(username);
		if (member==null) {
			return null;
		}
		else {
			if (!member.getPassword().equals(password)) {
				throw new IdPasswordNotMatchingException();
			}
			return member;
		}
	}
}
