package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController3 {
	@RequestMapping("/java/korea")
	public String ghi(Model model) {
		model.addAttribute("msg", "성공 /java/korea");
		return "list";
	}
	
	@GetMapping(value={"/java/good", "nice", "ok"})
	public String ghi2(Model model) {
		model.addAttribute("msg", "여러 개의 요청이 한 개의 메소드와 매핑");
		return "list";
	}
}
