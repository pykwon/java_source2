package anno1_auto;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@Configuration
//@ComponentScan(basePackages = "anno1_auto")
public class Main1 {

	public static void main(String[] args) {
		// @Autowired에 대한 메인
		//AnnotationConfigApplicationContext context = 
		//		new AnnotationConfigApplicationContext(Main1.class);
		
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:anno1.xml");
		
		SenderProcess process = 
				context.getBean("senderProcess", SenderProcess.class);
		process.dispData();
	}
}
