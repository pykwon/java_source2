package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pack.model.JepumModel;

@Controller
public class JepumController {
	@Autowired
	private JepumModel jepumModel;
	
	@GetMapping("insdata")
	public String method1() {
		return "redirect:input.html";
	}
	
	@PostMapping("insdata")
	public String method2(JepumBean bean, Model model) {
		model.addAttribute("data", jepumModel.computePrice(bean));
		return "result";
	}
}
