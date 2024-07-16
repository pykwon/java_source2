package pack;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test9")
public class TestController2 {
	@RequestMapping(method=RequestMethod.GET)
	public String def1(Model model) {
		// HttpServletRequest 객체에 값을 저장 후 뷰에 전닿
		model.addAttribute("msg", "success get");
		return "list";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public String def2(Model model) {
		model.addAttribute("msg", "success post");
		return "list";
	}
}
