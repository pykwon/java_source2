package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends JdbcDaoSupport {
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource);
	}

	//전체 자료 읽기
	public List<MemberDto> getMemberList(String jikwonJik){
		String sql = "select * from jikwon where jikwon_jik = ?";

		List<MemberDto> list = getJdbcTemplate().query(sql, new Object[]{jikwonJik}, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setJikwon_no(rs.getString("jikwon_no"));
				member.setJikwon_name(rs.getString("jikwon_name"));
				member.setJikwon_gen(rs.getString("jikwon_gen"));
				member.setJikwon_pay(rs.getString("jikwon_pay"));
				return member;
			}
		});

		return list;
	}
}
