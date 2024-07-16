package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sprweb5Application {

	public static void main(String[] args) {
		SpringApplication.run(Sprweb5Application.class, args)
			.getBean(Sprweb5Application.class).execute();		
	}
	
	@Autowired
	My my;
	
	@Autowired
	ProcessServiceImpl processServiceImpl;
	
	private void execute() {
		System.out.println("execute 메소드 수행");
		my.aaa();
		
		processServiceImpl.selectProcess();
	}
}
