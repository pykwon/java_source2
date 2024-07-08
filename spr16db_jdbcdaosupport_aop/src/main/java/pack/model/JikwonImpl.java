package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class JikwonImpl extends JdbcDaoSupport implements JikwonInter{
	@Autowired
	private DataSource dataSource;
	
	@PostConstruct
	public void abcd() {
		setDataSource(dataSource);
	}
	
	@Override
	public List<JikwonDto> selectList(String buserNum) throws DataAccessException {
		RowMapper rowMapper = new JikwonMapper();
		
		String sql= "select jikwon_no, jikwon_name, buser_name, buser_tel,jikwon_jik"
				  + " from jikwon inner join buser on jikwon.buser_num=buser.buser_no";
		switch (buserNum) {
		case "10":
		case "30":
		case "20":
		case "40":
			sql += " where buser_num=" + buserNum;
			break;
		}
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	class JikwonMapper implements RowMapper{
		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new JikwonDto() {
				{
					setJikwon_no(rs.getString("jikwon_no"));
					setJikwon_name(rs.getString("jikwon_name"));
					setBuser_name(rs.getString("buser_name"));
					setBuser_tel(rs.getString("buser_tel"));
					setJikwon_jik(rs.getString("jikwon_jik"));
				}
			};
		}
	}
}
