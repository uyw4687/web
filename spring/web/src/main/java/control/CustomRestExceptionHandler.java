package control;

import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomRestExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> invalidArgs(MethodArgumentNotValidException e) {
		String codes = e.getBindingResult().getAllErrors()
						.stream().map(error -> error.getCodes()[0])
						.collect(Collectors.joining(", "));
		return ResponseEntity.badRequest().body(codes);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public Object handleRtException() {
		return new ErrorResponse("runtime error");
	}
	
}
