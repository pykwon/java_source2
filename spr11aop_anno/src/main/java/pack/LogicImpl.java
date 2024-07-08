package pack;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogicImpl implements LogicInter{
	@Autowired
	private ArticleInter articleInter;
	
	public LogicImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void selectDataProcess1() {
		System.out.println("selectDataProcess1 수행");
		articleInter.selectAll();  // 모델 클래스 수행 결과
	}
	
	@Override
	public void selectDataProcess2() {
		System.out.println("-------------");
		System.out.println("selectDataProcess2 처리");
		articleInter.selectAll();  // 모델 클래스 수행 결과
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("3초 지연 처리");
	}
}
