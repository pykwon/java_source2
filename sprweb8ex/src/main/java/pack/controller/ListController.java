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
	
	@GetMapping("/testdb")// @리퀘스트파라미터 
	public String listProcess(@RequestParam(value="jikwon_jik") String jikwon_jik,
			Model model) {
		ArrayList<JikwonDto> list = dataDao.selectData(jikwon_jik);
		model.addAttribute("datas", list);
		return "show";
	}
	
}
