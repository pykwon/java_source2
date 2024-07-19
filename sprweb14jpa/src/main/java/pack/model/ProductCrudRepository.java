package pack.model;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductCrudRepository extends JpaRepository<ProductVo, Integer>{
	//CrudRepository > PagingAndSortingRepository > JpaRepository
	
	// 메소드 이름으로 쿼리 생성 방법  find + (엔티티 이름) + By + 변수 이름
	// 엔티티의 이름은 생략이 가능
	ProductVo findByCode(Integer code);

	//JPQL
	@Query(value = "select p from ProductVo as p")
	List<ProductVo> findAllData();
	
	
	// where 조건
	@Query(value = "select p from ProductVo as p where p.code=:code")
	ProductVo findByCodeMy(@Param("code") int code);
	
	@Query(value = "select p from ProductVo as p where p.code=?1")
	ProductVo findByCodeMy2(int code);
	
	@Query(value = "select p from ProductVo as p where p.code=?1 or p.sang=?2")
	List<ProductVo> findByData(int code, String sang);
	
	// native Query문 사용
	@Query(value = "select code,sang,su,dan from product where code <= 5", nativeQuery = true)
	List<ProductVo> findAllData2();
}











