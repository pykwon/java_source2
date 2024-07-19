package pack.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface jikRepo extends JpaRepository<JikEntity, Integer> {
	List<JikEntity> findByJik(String svalue);
}
