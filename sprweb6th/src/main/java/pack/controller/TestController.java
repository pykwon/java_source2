package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
	@GetMapping("thymeleaf")
	public String sijak(Model model) {
		model.addAttribute("msg", "타임리프 만세!");
		model.addAttribute("msg2", "영국이냐 스페인이냐?");
		
		// DTO 자료 출력용
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("삼다수3L");
		sangpum.setPrice("3000");
		model.addAttribute("sangpum", sangpum);
		
		ArrayList<Sangpum> list = new ArrayList<Sangpum>();
		list.add(sangpum);
		
		sangpum = new Sangpum();
		sangpum.setCode("20");
		sangpum.setSang("고구마빵");
		sangpum.setPrice("2000");
		list.add(sangpum);
		
		model.addAttribute("list", list);
		
		return "list1";
	}
}
