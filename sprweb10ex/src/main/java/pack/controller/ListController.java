package pack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class ListController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("list")
	public String listprocess(@RequestParam("jikwon_jik") String jikwonJik, Model model) {
		List<MemberDto> list = memberDao.getMemberList(jikwonJik);
		
		model.addAttribute("list", list);
		return "list";
	}
}



