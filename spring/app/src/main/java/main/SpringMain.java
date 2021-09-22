package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.BeanConfiguration;
import spring.AlreadyExistingMemberException;
import spring.ChangePasswordService;
import spring.CountPrinter;
import spring.IdPasswordNotMatchingException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;

public class SpringMain {
	
//	static String[] confs = {"classpath:conf1.xml", "classpath:conf2.xml"};
//	private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(confs);
	
//	private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:confImport.xml");

//	private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:autoConf.xml");

//	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfPart1.class, BeanConfPart2.class);

//	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfPart1.class);

//	private static ApplicationContext ctx = new GenericXmlApplicationContext("classpath:confPart2_rev.xml");
	
//	private static GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx.xml");

//	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfMaster.class);

	private static ApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfiguration.class);
	
	private static void processNewCommand(String[] cmd) {

		RegisterRequest req = new RegisterRequest();
		req.setEmail(cmd[1]);
		req.setPassword(cmd[2]);
		req.setPasswordConfirm(cmd[3]);
		req.setName(cmd[4]);
		MemberRegisterService regSvc = ctx.getBean("memRegSvc", MemberRegisterService.class);
		
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
		
		ChangePasswordService pwdSvc = ctx.getBean("chgPwdSvc", ChangePasswordService.class); 
		
		try {
			pwdSvc.changePassword(cmd[1], cmd[2], cmd[3]);
			System.out.println("변경 완료");
		} catch (MemberNotFoundException e) {
			System.out.println("가입하지 않았습니다.");
		} catch (IdPasswordNotMatchingException e) {
			System.out.println("비밀번호가 일치하지 않습니다.");
		}
		
	}
	
	private static void processPrintCommand() {
		
		MemberListPrinter printer = ctx.getBean(MemberListPrinter.class);
		printer.printMembers();
	
	}
	
	private static void processInfoCommand(String[] cmd) {
		
		MemberInfoPrinter printer = ctx.getBean("memInfoPrinter", MemberInfoPrinter.class);
		printer.printInfo(cmd[1]);
	
	}

	private static void processVersionCommand() {
		
		VersionPrinter printer = ctx.getBean("verPrinter", VersionPrinter.class);
		printer.print();
		
	}

	private static void processCountCommand() {
		
		CountPrinter printer = ctx.getBean("cntPrinter", CountPrinter.class);
		printer.print();
		
	}
	
	public static void main(String[] args) throws IOException {

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
			else if (cmd.equals("print")) {
				
				processPrintCommand();
				continue;
				
			}
			else if (cmd.startsWith("info")) {
				
				String[] splited = cmd.split(" ");
				if (splited.length == 2) {
					processInfoCommand(splited);
					continue;
				}
				
			}
			else if (cmd.equals("version")) {
				
				processVersionCommand();
				continue;
				
			}
			else if (cmd.equals("count")) {
				
				processCountCommand();
				continue;
				
			}
			else if (cmd.isEmpty()) {

				continue;
			
			}
			
			System.out.println("new ~ ~ ~ ~");
			System.out.println("change ~ ~ ~");
			System.out.println("print");
			System.out.println("info ~");
			System.out.println("version");
			System.out.println("count");

		}
		
	}
	
}
