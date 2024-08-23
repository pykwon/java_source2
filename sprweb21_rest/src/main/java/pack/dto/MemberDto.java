package pack.dto;

import org.apache.ibatis.type.Alias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("memberDto")  // 객체 별명을 주고 mapper.xml 문서에서 사용
public class MemberDto {
	private int num;
	private String name;
	private String addr;
}
