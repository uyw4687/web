package member.auth.chgPass;

import javax.validation.constraints.NotBlank;

public class ChgPassData {
	
	@NotBlank
	private String prevPass;
	@NotBlank
	private String newPass;

	public String getPrevPass() {
		return prevPass;
	}
	public void setPrevPass(String prevPass) {
		this.prevPass = prevPass;
	}
	public String getNewPass() {
		return newPass;
	}
	public void setNewPass(String newPass) {
		this.newPass = newPass;
	}
	
}
