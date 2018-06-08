package oscipovsky.lukas.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

	@GetMapping(path = "health/status")
	public HttpStatus healthstatus() {
		return HttpStatus.OK;
	}
}
