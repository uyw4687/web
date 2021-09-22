package version.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import version.Version;

@RestController
public class VersionRestController {
	
	Version ver;
	
	public VersionRestController(Version ver) {
		this.ver = ver;
	}
	
	@GetMapping("/version")
	public String version() {
		return ver.getVersion();
	}

}
