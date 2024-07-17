package pack.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class ListController {
	@Autowired
	private DataDao dataDao;
	
	@GetMapping("/")
	public String sijak() {
        return "index";
    }
	
	@GetMapping("jikwon")
	public String process(@RequestParam(name="jikwon_jik", required = false)String jikwon_jik, Model model) {
        ArrayList<JikwonDto> list = (ArrayList<JikwonDto>)dataDao.getDataAll(jikwon_jik);
        model.addAttribute("datas", list);
        return "list";
    }
	
}
