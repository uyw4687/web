package spring;

import org.springframework.stereotype.Component;

@Component(value = "memPrinter")
public class MemberPrinter {

	public void print(Member m) {
			
		System.out.printf("ord : %s, email : %s, name : %s, date : %tF\r\n",
				m.getId(), m.getEmail(), m.getName(), m.getRegisterDate());
		
	}
	
}
