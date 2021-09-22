package member.auth.chgPass;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import member.auth.AuthInfo;
import member.auth.IdPasswordNotMatchingException;

@Controller
public class ChgPassController {
	
	ChangePasswordService pwdSvc;
	
	public ChgPassController(ChangePasswordService pwdSvc) {
		this.pwdSvc = pwdSvc;
	}
	
	@GetMapping("/chgPass")
	public String form(@ModelAttribute("chgPassData") ChgPassData chgPassData) {
		return "chgPass/changePassword";
	}
	
	@PostMapping("/chgPass")
	public String changePassword(@Valid @ModelAttribute("chgPassData") ChgPassData chgPassData, Errors errors, HttpSession session) {
		
		if (errors.hasErrors()) {
			return "chgPass/changePassword";
		}
		try {
			pwdSvc.changePassword(((AuthInfo)session.getAttribute("authInfo")).getEmail(),
					chgPassData.getPrevPass(), chgPassData.getNewPass());
		} catch (IdPasswordNotMatchingException e) {
			errors.rejectValue("prevPass", "notMatch");
			return "chgPass/changePassword";
		}

		return "chgPass/done";
	}
	
}
