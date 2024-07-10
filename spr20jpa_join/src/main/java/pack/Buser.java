package pack;

import javax.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="buser")
public class Buser {
	@Id
	@Column(name="buser_no")
	private int buserNo;
	
	@Column(name="buser_name")
	private String buserName;
}
