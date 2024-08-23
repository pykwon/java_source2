package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.dto.JikwonDto;

@Repository
public class TestDao {

	@Autowired
	private JikwonInterface jitf;

	public List<JikwonDto> getJikwonData(String jik) {
		return jitf.findByJik(jik).stream().map(JikwonDto::toDto).toList();
	}
	
	public List<JikwonDto> getJikwon() {
		return jitf.findAll().stream().map(JikwonDto::toDto).toList();
	}

}
