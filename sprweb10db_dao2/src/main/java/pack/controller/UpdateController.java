package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.MemberDao;
import pack.model.MemberDto;

@Controller
public class UpdateController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("update")
	public String update(@RequestParam("id")String id, Model model) {
		MemberDto dto = memberDao.getMember(id);
		model.addAttribute("member", dto);
		return "update";
	}
	
	@PostMapping("update")
	public String updateProcess(MemberBean bean, Model model) {
		memberDao.upData(bean);

		return "redirect:/list";  // 수정 후 목록 보기
	}
}
