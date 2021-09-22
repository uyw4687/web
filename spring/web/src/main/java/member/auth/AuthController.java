package member.auth;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import member.Member;

@Controller
public class AuthController {
	LoginService loginSvc;
	
	public AuthController(LoginService loginSvc) {
		this.loginSvc = loginSvc;
	}

	@GetMapping("/login")
	public String form(@ModelAttribute("login") LoginData login, @CookieValue(name = "email", required = false) Cookie emCookie) {
//		Cookie[] cs = request.getCookies();
//		for (int i=0;i<cs.length;i++) {
//			if (cs[i].getName().equals("email")) {
//				login.setEmail(cs[i].getValue());
//				login.setRemember(true);
//				break;
//			}
//		}
		if (emCookie!=null) {
			login.setEmail(emCookie.getValue());
			login.setRemember(true);
		}
		return "login";
	}
	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LoginData data, Errors errors,
			HttpSession session, HttpServletResponse response) {
		if (errors.hasErrors()) {
			return "login";
		}
		try {
			Member member = loginSvc.login(data.getEmail(), data.getPassword());
			if (member==null) {
				errors.rejectValue("username", "notExist");
				return "login";
			}
			AuthInfo authInfo = new AuthInfo(member.getEmail(), member.getName());
			session.setAttribute("authInfo", authInfo);
			
			Cookie remCookie = new Cookie("email", member.getEmail());
			if (data.isRemember()) {
				remCookie.setMaxAge(60 * 60 * 24 * 30);
			} else {
				remCookie.setMaxAge(0);
			}
			response.addCookie(remCookie);			
			return "main";
		} catch(IdPasswordNotMatchingException e) {
			errors.rejectValue("password", "notMatch");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}
	
}