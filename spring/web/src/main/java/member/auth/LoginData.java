package member.auth;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

public class LoginData {

	@NotBlank
	private String email;
	@NotEmpty
	private String password;
	private boolean remember;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isRemember() {
		return remember;
	}
	public void setRemember(boolean remember) {
		this.remember = remember;
	}
	
}
