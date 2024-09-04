 package pack.entity;

 
import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jikwon")
public class Jikwon {
	
	@Id
	@Column(name = "jikwon_no")
	private String no;
	
	@Column(name = "jikwon_name")
	private String name;
	
	@Column(name = "jikwon_jik")
	private String jik;
	
	@Column(name = "jikwon_pay")
	private String pay;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "buser_num", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
	private Buser buser;
	
}
