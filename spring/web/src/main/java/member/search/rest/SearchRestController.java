package member.search.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import control.ErrorResponse;
import member.Member;
import member.search.MemberSearchService;
import member.search.NoSuchMemberException;

@RestController
public class SearchRestController {
	
	MemberSearchService searchSvc;
	
	public SearchRestController(MemberSearchService searchSvc) {
		this.searchSvc = searchSvc;
	}

	@GetMapping("/member/rest/{id}")
	public Member info(@PathVariable long id) {
		Member member = searchSvc.getMemberById(id);
		return member;
	}
	
	@GetMapping("/members/rest")
	public List<Member> list() {
		return searchSvc.list();
	}
	
	@ExceptionHandler(NoSuchMemberException.class)
	public ResponseEntity<Object> noMember() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse("no member by that id"));
	}

}
