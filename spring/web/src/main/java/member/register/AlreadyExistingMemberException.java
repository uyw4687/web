package member.register;

public class AlreadyExistingMemberException extends RuntimeException {

	public AlreadyExistingMemberException(String msg) {
		super(msg);
	}
	
}
