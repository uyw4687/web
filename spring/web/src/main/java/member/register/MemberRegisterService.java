package member.register;

import java.time.LocalDateTime;

import member.Member;
import member.MemberDao;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
//	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public long regist(RegisterData req) {
		if (memberDao.selectByEmail(req.getEmail())!=null) {
			throw new AlreadyExistingMemberException("email " + req.getEmail() + " already exists");
		}
	
		Member newMember = new Member(req.getEmail(),
									  req.getPassword(),
									  req.getName(),
									  LocalDateTime.now());
		
		return memberDao.insert(newMember);
	}

}
