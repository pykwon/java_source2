package pack.gogek;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GogekMain {
	public static void main(String[] args) {
		ApplicationContext context = 
			new ClassPathXmlApplicationContext("bankinit.xml");
		
		Gogek daniel = (Gogek)context.getBean("gogek");
		daniel.selectBank("sinhan");
		daniel.playInputMoney(500);
		daniel.playOutputMoney(200);
		System.out.print("daniel - ");
		daniel.showMoney();
		
		Gogek john = (Gogek)context.getBean("gogek");
		john.selectBank("sinhan");
		john.playInputMoney(500);
		john.playOutputMoney(200);
		System.out.print("john - ");
		john.showMoney();
		
		Gogek oscar = (Gogek)context.getBean("gogek");
		oscar.selectBank("hana");
		oscar.playInputMoney(500);
		oscar.playOutputMoney(100);
		System.out.print("oscar - ");
		oscar.showMoney();
		
		System.out.println("객체 주소 daniel: " + daniel);
		System.out.println("객체 주소 john: " + john);
		System.out.println("객체 주소 oscar: " + oscar);
	}
}
