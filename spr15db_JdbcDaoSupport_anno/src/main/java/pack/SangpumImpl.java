package pack;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl extends JdbcDaoSupport implements SangpumInter{
	@Autowired
	public SangpumImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
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
			//System.out.println("rowNum : " +  rowNum);
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




