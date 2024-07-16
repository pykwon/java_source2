package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao extends JdbcDaoSupport{
	// JdbcDaoSupport : dataSource, jdbcTemplate  <== getter, setter 있다
	@Autowired
	public DataDao(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	// getJdbcTemplate().query(sql, new ItemRowMapper())는 JDBC 템플릿을 사용하여 쿼리를 실행하고, 
	// 결과 집합을 ItemRowMapper를 통해 SangpumDto 객체로 변환
	public List<SangpumDto> getDataAll(){
		String sql = "select * from sangdata";
		return (List)getJdbcTemplate().query(sql, new ItemRowMapper());
	}
	
	class ItemRowMapper implements RowMapper<Object>{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			SangpumDto dto = new SangpumDto();
			dto.setCode(rs.getString("code"));
			dto.setSang(rs.getString("sang"));
			dto.setSu(rs.getString("su"));
			dto.setDan(rs.getString("dan"));
			return dto;
		}
	}
}
