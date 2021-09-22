package control.validate;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import member.register.RegisterData;

public class RegisterValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return RegisterData.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		RegisterData req = (RegisterData) target;
		String email = req.getEmail();
		
		if (email==null || email.trim().isEmpty()) {
			errors.rejectValue("email", "empty");
		}
		else if (!Pattern.matches("^[A-Za-z0-9-_\\+]+[\\.A-Za-z0-9-_\\+]*@[A-Za-z0-9_]+[\\.A-Za-z0-9]*.[A-Za-z]{2,}$", email)) {
			errors.rejectValue("email", "malformed");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "empty");
		
		if (!req.isPasswordEqualToConfirmPassword()) {
			errors.rejectValue("passwordConfirm", "notEqual");
		}
	}

}
