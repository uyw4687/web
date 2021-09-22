package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import assembler.Assembler;
import spring.AlreadyExistingMemberException;
import spring.ChangePasswordService;
import spring.IdPasswordNotMatchingException;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;

public class AssemblerMain {

	private static Assembler assembler = new Assembler();
	
	private static void processNewCommand(String[] cmd) {

		RegisterRequest req = new RegisterRequest();
		req.setEmail(cmd[1]);
		req.setPassword(cmd[2]);
		req.setPasswordConfirm(cmd[3]);
		req.setName(cmd[4]);
		MemberRegisterService regSvc = assembler.getMemberRegisterServicer();;
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("비밀번호 확인 값이 비밀번호와 일치하지 않습니다.");
			return;
		}

		try {
			regSvc.regist(req);
			System.out.println("완료");
		} catch (AlreadyExistingMemberException e) {
			System.out.println("이미 가입하셨습니다.");
		}
		
	}

	private static void processChangeCommand(String[] cmd) {
	
		ChangePasswordService pwdSvc = assembler.getChangePasswordService(); 
		
		try {
			pwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
			System.out.println("변경 완료");
		} catch (MemberNotFoundException e) {
			System.out.println("가입하지 않았습니다.");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
		
	}
	
	public static void main(String[] aㅓrgs) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("서비스 시작");
		while (true) {

			String cmd = reader.readLine();
			if (cmd.startsWith("exit")) {
				break;
			}
			else if (cmd.startsWith("new")) {
				
				String[] splited = cmd.split(" ");
				if(splited.length == 5) {
					processNewCommand(splited);
					continue;
				}
				
			}
			else if (cmd.startsWith("change")) {
				
				String[] splited = cmd.split(" ");
				if(splited.length == 4) {
					processChangeCommand(splited);
					continue;
				}
				
			}
			
			System.out.println("new ~ ~ ~ ~");
			System.out.println("or");
			System.out.println("change ~ ~ ~");

		}
		
	}

}
