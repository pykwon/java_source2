package pack;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloMain {
	public static void main(String[] args) {
		// 처리 1 : 전통적 방법
		Message1 m1 = new Message1();
		m1.sayHello("신선해");
		
		Message2 m2 = new Message2();
		m2.sayHello("신기루");
		
		System.out.println();
		MessageInter inter;
		inter = m1;
		inter.sayHello("손오공");
		inter = m2;
		inter.sayHello("저팔계");
		
		System.out.println("----------");
		// 처리 2 : Spring 방법
		//ApplicationContext context = 
		//		new ClassPathXmlApplicationContext("classpath:pack/init.xml");
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("init.xml");
		MessageInter inter2 = (MessageInter)context.getBean("mes1");
		inter2.sayHello("유비");
		MessageInter inter3 = (MessageInter)context.getBean("mes2");
		inter3.sayHello("관우");
		
	}
}






