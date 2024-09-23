package pack.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "customer")
public class Customer {
	@Id
	private String id;
	private String name;
	private String age;
	private String gender;
	
	@Override
	public String toString() {
		return "Customer{ " + 
				"id:" + id + 
				", name:" + name + 
				", age:" + age +
				", gender:" + gender + 
				" }";
	}
}
