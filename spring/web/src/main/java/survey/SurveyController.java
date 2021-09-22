package survey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@GetMapping
	public ModelAndView initPage() {
		List<Question> qs = getQuestions();
		ModelAndView mv = new ModelAndView();
		mv.addObject("questions", qs);
		mv.setViewName("survey/survey");
		return mv;
	}
	
	private List<Question> getQuestions() {
		List<Question> qs = new ArrayList<>();
		qs.add(new Question("1. 직무를 선택하세요.", Arrays.asList("서버", "프론트", "풀스택")));
		qs.add(new Question("2. 개발도구를 선택하세요.", Arrays.asList("Eclipse", "Intellij", "Sublime")));
		qs.add(new Question("3. 하고 싶은 말", null));
		return qs;
	}
	
	@PostMapping
	public String procResult(Survey survey) {
		return "survey/done";
	}

	@GetMapping("/tags")
	public ModelAndView tags(Login login) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("loginTypes", Arrays.asList(new LoginType("아이디", "id"), new LoginType("이메일", "email"), new LoginType("구글", "google")));
		mv.setViewName("survey/tags");
		return mv;
	}
}
