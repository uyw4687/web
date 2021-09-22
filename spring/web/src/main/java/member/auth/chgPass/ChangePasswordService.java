package member.auth.chgPass;

import org.springframework.transaction.annotation.Transactional;

import member.Member;
import member.MemberDao;
import member.search.MemberNotFoundException;

public class ChangePasswordService {

	private MemberDao memberDao;

//	@Autowired
	public ChangePasswordService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	public void changePassword(String email, String oldPassword, String newPassword) {

		Member member = memberDao.selectByEmail(email);
		if (member == null) {
			throw new MemberNotFoundException();
		}
		
		member.changePassword(oldPassword, newPassword);	
		memberDao.update(member);
		
	}
	
}
