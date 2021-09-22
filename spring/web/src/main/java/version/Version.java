package version;

import org.springframework.beans.factory.annotation.Value;

public class Version {

	@Value("${version.major}")
	private int majorVersion;
	private int minorVersion;

	public void setMajorVersion(int majorVersion) {
		this.majorVersion = majorVersion;
	}

	@Value("${version.minor}")
	public void setMinorVersion(int minorVersion) {
		this.minorVersion = minorVersion;
	}

	public String getVersion() {
		return majorVersion + "." + minorVersion;
	}

}
