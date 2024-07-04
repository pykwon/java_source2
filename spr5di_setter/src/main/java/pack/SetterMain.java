package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterMain {

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("configuration.xml");
		OurProcess our = (OurProcess)context.getBean("our");
		System.out.println(our);
		//System.out.println(our.toString());
	}

}
