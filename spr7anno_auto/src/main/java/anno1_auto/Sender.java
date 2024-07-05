package anno1_auto;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component    // single pattern으로 Sender 객체가 생성. 객체 변수명은 sender
//@Component("sender")
//@Component("sen")
//@Scope("singleton")
public class Sender implements SenderInter{
	public void show() {
		System.out.println("Sender의 show method 수행");
	}
}
