package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JikwonDTO {
	private int jikwon_no;
	private String jikwon_name;
	private String buser_num;
	private String jikwon_ibsail;
	private int jikwon_pay; 
}