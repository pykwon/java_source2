package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
//@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SangpumDto { 
	private String code, sang, su, dan;

}
