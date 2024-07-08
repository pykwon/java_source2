package pack.business;

import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pack.model.JikwonDto;
import pack.model.JikwonInter;

@Service
public class BusinessImpl implements BusinessInter{
	// model을 포함관계로 호출
	@Autowired
	private JikwonInter jikwonInter;
	
	@Override
	public void jikwonList() {
		System.out.print("부서번호 입력:");
		Scanner scanner = new Scanner(System.in);
		String buserNum = scanner.nextLine();
		scanner.close();
		
		int count = 0;
		for(JikwonDto j:jikwonInter.selectList(buserNum)) {
			System.out.println(j.getJikwon_no() + " " + 
					j.getJikwon_name() + " " +
					j.getBuser_name() + " " +
					j.getBuser_tel() + " " +
					j.getJikwon_jik());
			count++;
		}
		System.out.println("인원 수 :" + count);
	}
}
