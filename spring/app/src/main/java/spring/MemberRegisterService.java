package spring;

import java.util.Date;

public class MemberRegisterService {
	
	private MemberDao memberDao;
	
//	@Autowired
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	public void regist(RegisterRequest req) {
		
		if (memberDao.selectByEmail(req.getEmail())!=null) {
			throw new AlreadyExistingMemberException("email " + req.getEmail() + " already exists");
		}
	
		Member newMember = new Member(req.getEmail(),
									  req.getPassword(),
									  req.getName(),
									  new Date());
		memberDao.insert(newMember);
		
	}

}
