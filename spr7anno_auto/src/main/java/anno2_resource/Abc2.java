package anno2_resource;

import org.springframework.stereotype.Component;

@Component("aaa")
public class Abc2 {   // POJO(Plain Old Java Object)
	private int nai;
	
	public void setNai(int nai) {
		this.nai = nai;
	}
	
	public int getNai() {
		return nai;
	}
}
