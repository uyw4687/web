package spring;

//@Component("memPrinter")
public class MemberPrinter2 {

	public void print(Member m) {
			
		System.out.printf("ord : %s, email : %s, name : %s, date : %tF\r\n",
				m.getId(), m.getEmail(), m.getName(), m.getRegisterDate());
		
	}

}
