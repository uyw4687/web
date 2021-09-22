package member.auth;

public class AuthInfo {

	private String email;
	private String name;
	
	public AuthInfo(String email, String name) {
		this.email = email;
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	public String getName() {
		return name;
	}
	
}
