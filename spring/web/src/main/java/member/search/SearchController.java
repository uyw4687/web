package member.search;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import member.Member;

@Controller
public class SearchController {

	MemberSearchService searchSvc;
	
	public SearchController(MemberSearchService searchSvc) {
		this.searchSvc = searchSvc;
	}

	@GetMapping("/member/{id}")
	public String info(@PathVariable("id") long id, Model model) {
		Member member = searchSvc.getMemberById(id);
		model.addAttribute("member", member);
		return "search/member";
	}

	@GetMapping("/members")
	public String all(Model model) {
		List<Member> list = searchSvc.list();
		model.addAttribute("list", list);
		return "search/list";
	}
	
	@GetMapping("/search")
	public String form(@ModelAttribute("command") SearchData req) {
		return "search/form";
	}
	
	@PostMapping("/search")
	public String search(@Valid @ModelAttribute("command") SearchData req, Errors errors, Model model) {
		if (errors.hasErrors()) {
			return "search/form";
		}
		
		List<Member> list = searchSvc.searchInterval(req.getFrom(), req.getTo());
		model.addAttribute("list", list);
		return "search/list";
	}
	
	@ExceptionHandler(NoSuchMemberException.class)
	public String noMember() {
		return "error/search/noMember";
	}
	
}