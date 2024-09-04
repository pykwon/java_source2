package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pack.entity.Jikwon;
 
public interface JikwonInterface extends JpaRepository<Jikwon, String> {
	public List<Jikwon> findByJik(String jik);
	
}
