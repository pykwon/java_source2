package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Select;
 
public interface SqlMapper_Inter {
	@Select("select jikwon_no, jikwon_name, buser_num, substr(jikwon_ibsail,1,4) as jikwon_ibsail from jikwon")
	List<JikwonDTO> selectDataAll();
	
	@Select("select count(*) from jikwon where buser_num = #{buser_num}")
	int buserCount(String buser_num);

	@Select("select jikwon_name, jikwon_pay from jikwon where buser_num = #{buser_num} order by jikwon_pay desc limit 1")
	JikwonDTO getHightPay(String buser_num);
}
