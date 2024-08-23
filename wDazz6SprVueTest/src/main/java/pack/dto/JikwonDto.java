package pack.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pack.entity.Jikwon;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JikwonDto {
	private String no, name, jik, bname, pay;
	
	public static JikwonDto toDto(Jikwon jikwon) {
		return JikwonDto.builder()
				.no(jikwon.getNo())
				.name(jikwon.getName())
				.jik(jikwon.getJik())
				.bname(jikwon.getBuser().getName())
				.pay(jikwon.getPay())
				.build();
	}
}
