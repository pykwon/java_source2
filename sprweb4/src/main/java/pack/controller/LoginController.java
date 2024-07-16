package pack.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class LoginController {
	// 로그 정보 출력용 클래스
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@GetMapping("login")
	public String submitCall() {
		//return "login.html";  // forward : 기본 값
		
		return "redirect:login.html";  // redirect 명시적 적어줌
		//return "redirect:http://localhost/login.html";
	}
	
	// 클라이언트가 전달한 값 수신 방법 1 : 전통적
	/*
	@PostMapping("login")
	public String submit(HttpServletRequest request, Model model) {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		System.out.println(id + " " + pwd);
		logger.info(id + " " + pwd); // 로그레벨 trace > debug > info > warn > error > fatal
		
		String data = "";
		if(id.equals("kor") && pwd.equals("111"))
			data = "로그인 성공";
		else
			data = "로그인 실패";
		
		model.addAttribute("data", data);
		
		return "result";
	}
	*/
	
	// 클라이언트가 전달한 값 수신 방법 2 : Spring 어노테이션 사용
	@PostMapping("login")
	public String submit(@RequestParam(value = "id")String id, 
						//@RequestParam(value = "pwd")String pwd,
						//@RequestParam(value = "pwd")int pwd,
						@RequestParam(value = "pwd", defaultValue = "111")int pwd,
						Model model) {
		String data = "";
		//if(id.equals("kor") && pwd.equals("111"))
		if(id.equals("kor") && pwd == 111)
			data = "로그인 성공";
		else
			data = "로그인 실패";
		
		model.addAttribute("data", data);
		return "result";
	}
}
