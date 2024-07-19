package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonDao {
	@Autowired
	private jikRepo repo;
	
	//특정 자료 읽기
	public List<JikEntity> getSearchValue(String jik){
		List<JikEntity> list = repo.findByJik(jik);
		return list;
	}
}
