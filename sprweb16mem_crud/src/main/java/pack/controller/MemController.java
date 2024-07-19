package pack.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import pack.model.DataProcess;
import pack.model.Mem;

@Controller
public class MemController {
	@Autowired
	private DataProcess dataProcess;
	
	@GetMapping("/")
	public String main() {
		return "chulbal";
	}
	
	@GetMapping("list")
	public String list(Model model) {
		ArrayList<Mem> list = (ArrayList<Mem>)dataProcess.getDataAll();
		model.addAttribute("datas", list);
		return "list";
	}
	
	@GetMapping("insert")
	public String insert() {
		return "insert";
	}
	
	
	@PostMapping("insert")
	public String insertProcess(Model model){

		boolean b = dataProcess.insert(bean);
		if(b)
			return "redirect:/list";
		else
			return "redirect:/error";	
	}
	
	@GetMapping("error")
	public String error() {
		return "error";
	}

}
