package pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

@Repository
public class SangpumImpl implements SangpumInter{
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public SangpumImpl() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("driver loadding 실패:" + e.getMessage());
		}
	}
	 
	@Override
	public ArrayList<SangpumDto> selectAll() {
		ArrayList<SangpumDto> list = new ArrayList<SangpumDto>();
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test", "root", "123");
			pstmt = conn.prepareStatement("select * from sangdata");
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SangpumDto dto = new SangpumDto();
				dto.setCode(rs.getString("code"));
				dto.setSang(rs.getString("sang"));
				dto.setSu(rs.getString("su"));
				dto.setDan(rs.getString("dan"));
				list.add(dto);
			}
		} catch (Exception e) {
			System.out.println("selectAll err : " + e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return list;
	}
}






