package pack.model;

import java.util.List;

public interface DataInter {
	List<JikwonDto> selectAllJikwon(); // 전체 직원 정보
	List<Object[]> selectCount(); // 부서별 인원
}
