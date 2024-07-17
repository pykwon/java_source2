package pack.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import pack.controller.MemberBean;

@Repository
public class MemberDao extends JdbcDaoSupport{
	
	@Autowired
	public MemberDao(DataSource dataSource) {
		setDataSource(dataSource);
	}
	
	// 전체 자료 읽기
	public List<MemberDto> getMemberList(){
		String sql = "select * from memberteb";
		/*
		List<MemberDto> list = getJdbcTemplate().query(sql, new RowMapper() {
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto member = new MemberDto();
				member.setId(rs.getString("id"));
				member.setName(rs.getString("name"));
				member.setPasswd(rs.getString("passwd"));
				member.setReg_date(rs.getString("reg_date"));
				return member;
			}
		});
		*/
		
		// 람다 표현식 사용
		List<MemberDto> list = getJdbcTemplate().query(sql, (ResultSet rs, int rowNum) -> {
			MemberDto member = new MemberDto();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPasswd(rs.getString("passwd"));
			member.setReg_date(rs.getString("reg_date"));
			return member;
		});
		
		return list;
	}
	
	// 추가
	public void insData(MemberBean bean) {
		String sql = "insert into memberteb values(?,?,?,now())";
		
		Object[] params = {bean.getId(), bean.getName(), bean.getPasswd()};
		getJdbcTemplate().update(sql, params);
	}
	
	// 특정 레코드 읽기
	public MemberDto getMember(String id) {
		String sql = "select * from memberteb where id=?";
		
		MemberDto dto = (MemberDto)getJdbcTemplate().queryForObject(sql, new Object[] {id}, new RowMapper(){
			@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberDto dto = new MemberDto();
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setPasswd(rs.getString("passwd"));
				dto.setReg_date(rs.getString("reg_date"));
				return dto;
			}
		});
		return dto;
	}
	
	// 수정
	public void upData(MemberBean bean) {
		String sql = "update memberteb set name=?,passwd=? where id=?";
		getJdbcTemplate().update(sql, 
				new Object[] {bean.getName(),bean.getPasswd(),bean.getId()});
	}
	
	// 삭제
	public void delData(String id) {
		String sql = "delete from memberteb where id=?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
}











