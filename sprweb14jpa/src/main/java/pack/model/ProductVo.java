package pack.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product")
public class ProductVo {
	@Id
	@Column(name="code")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int code;
	
	@Column(name = "sang", nullable = true, length = 20)
	private String sang;
	
	private int su;
	private int dan;
}
