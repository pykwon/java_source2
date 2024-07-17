package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.MemberDao;

@Controller
public class DeleteController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping("delete")
	public String updateProcess(@RequestParam("id")String id) {
		memberDao.delData(id);
		return "redirect:/list";  // 삭제 후 목록 보기
	}
}
