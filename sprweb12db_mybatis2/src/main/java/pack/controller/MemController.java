package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemController {
	
	@GetMapping("/")
	public String chulbal() {
		return "chulbal";
	}
}
