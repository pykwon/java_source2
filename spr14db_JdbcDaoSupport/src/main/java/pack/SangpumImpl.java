package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	// JdbcDaoSupport 클래스는 Spring 프레임워크에서 제공하는 추상 클래스로, 
	// 데이터베이스와 상호 작용하는 DAO를 개발할 때 편리한 기능을 제공. 
	// 이 클래스는 JdbcTemplate을 사용하여 데이터베이스 작업을 처리하고,
	// 템플릿 메소드 패턴을 활용하여 일반적인 데이터 액세스 작업을 구현.
	
	// JdbcDaoSupport의 멤버 메소드 중
	// getJdbcTemplate()
	// setDataSource()
	
	@Override
	public ArrayList<SangpumDto> selectAll() {
		RowMapper rowMapper = new SangpumRowMapper();
		
		return (ArrayList)getJdbcTemplate().query("select * from sangdata", rowMapper);
	}
	
	// 내부 클래스
	class SangpumRowMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			// PreparedStatement에 의해 select의 실행 결과가 mapRow로 전달됨. rs.next() X
			System.out.println("rowNum : " +  rowNum);
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
			// rowMapper에 의해 dto가 List 컬렉션에 저장. 레코드 자료가 소진될 때까지. 
		}
	}
}




