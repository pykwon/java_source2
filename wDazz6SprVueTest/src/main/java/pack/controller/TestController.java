package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.JikwonDto;
import pack.model.TestDao;

@CrossOrigin("*")
@RestController
public class TestController {
	
	@Autowired
	private TestDao trps;

	@GetMapping("/jikwon/{jik}") 
	public List<JikwonDto> getJikwonData(@PathVariable("jik") String jik) {
		return trps.getJikwonData(jik);
	}
	
	@GetMapping("/jikwon/")
	public List<JikwonDto> getJikwon() {
		return trps.getJikwon();
	}
}
