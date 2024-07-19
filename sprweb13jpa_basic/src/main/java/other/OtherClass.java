package other;

import org.springframework.stereotype.Component;

@Component
public class OtherClass {
	public OtherClass() {
		System.out.println("OtherClass");
	}
	
	public void abc() {
		System.out.println("abc 메소드");
	}
}
