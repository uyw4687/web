package member.register;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JoinController {

	MemberRegisterService regSvc;
	
	public JoinController(MemberRegisterService regSvc) {
		this.regSvc = regSvc;
	}
	
	@GetMapping("/register/step1")
	public String step1() {
		return "register/step1";
	}
	
	@GetMapping("/register/step2")
	public String step2Get() {
		return "redirect:/register/step1";
	}
	
	@PostMapping("/register/step2")
	public String step2(@RequestParam(name = "agree", defaultValue = "false") boolean agree, Model model) {
		if (agree) {
			model.addAttribute("req", new RegisterData());
			return "register/step2";
		}
		else {
			return "register/step1";
		}
	}
	
	@PostMapping("/register/step3")
	public String step3(@Valid @ModelAttribute(name = "req") RegisterData req, Errors errors) {
		
		if (errors.hasErrors()) {
			return "/register/step2";
		}
		
		try {
			regSvc.regist(req);
			return "/register/step3";
		} catch (AlreadyExistingMemberException e) {
			errors.rejectValue("email", "duplicate");
			return "/register/step2";
		}

	}
//	
}
