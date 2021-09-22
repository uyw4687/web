package control;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(RuntimeException.class)
	public String handleRtException() {
		return "error/runtime";
	}
	
}
