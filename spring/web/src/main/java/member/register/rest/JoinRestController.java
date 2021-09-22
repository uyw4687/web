package member.register.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import control.ErrorResponse;
import member.register.AlreadyExistingMemberException;
import member.register.MemberRegisterService;
import member.register.RegisterData;

@RestController
public class JoinRestController {

	MemberRegisterService regSvc;
	
	public JoinRestController(MemberRegisterService regSvc) {
		this.regSvc = regSvc;
	}
	
	@PostMapping("/member/rest")
	public ResponseEntity<Object> create(@RequestBody @Valid RegisterData req) {
		long id = -1;
		try {
			id = regSvc.regist(req);
		} catch (AlreadyExistingMemberException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorResponse("Given email is already used."));
		}
		
		URI uri = null;
		try {
			uri = new URI("/member/"+id);
		} catch (URISyntaxException e) {
		}
		return ResponseEntity.created(uri).build();
	}
	
}
