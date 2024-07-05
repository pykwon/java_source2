package anno3_etc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main3 {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("anno3.xml");
		
		MyProcess process = context.getBean("my", MyProcess.class);
		process.showData();
	}
}
