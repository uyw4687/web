package spring;

public class VersionPrinter {

	private int majorVersion;
	private int minorVersion;

	public VersionPrinter(int majorVersion, int minorVersion) {

		this.majorVersion = majorVersion;
		this.minorVersion = minorVersion;
	
	}

	public VersionPrinter() {
		
	}
	
	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public void print() {

		System.out.println(majorVersion + "." + minorVersion);
	
	}

}
