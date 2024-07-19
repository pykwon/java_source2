package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "jikwon")
public class JikEntity {
	@Id
	@Column(name = "jikwon_no")
	private int no;

	@Column(name = "jikwon_name")
	private String name;

	@Column(name = "jikwon_gen")
	private String gen;

	@Column(name = "jikwon_pay")
	private String pay;

	@Column(name = "jikwon_jik")
	private String jik;
}
