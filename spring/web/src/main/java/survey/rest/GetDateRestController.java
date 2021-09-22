package survey.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetDateRestController {

	@PostMapping("/survey/date")
	public ResponseEntity<Object> getDate(@RequestBody DateData dd) {
		System.out.println(dd.getLdt());
		return ResponseEntity.noContent().build();
	}
	
}
