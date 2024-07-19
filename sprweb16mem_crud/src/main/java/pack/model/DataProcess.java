package pack.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	@Autowired
	private MemRepository memRepository;
	
	// 전체 자료 읽기
	public List<Mem> getDataAll(){
		List<Mem> list = memRepository.findAll();
		return list;
	}
	
	// 추가
	public String insert(MemBean bean) {
		// num 자동 증가
		//int max = memRepository.findByMaxNum();
		
		// num 중복 확인
		try {
			Mem mem = memRepository.findById(bean.getNum()).get();
			System.out.println("mem : " + mem);
			return "이미 등록된 번호입니다";
		} catch (Exception e) {
			try {
				Mem mem = new Mem();
				mem.setNum(bean.getNum());
				mem.setName(bean.getName());
				mem.setAddr(bean.getAddr());
				mem = memRepository.save(mem);
				System.out.println("mem : " + mem);
				return "success";
			} catch (Exception e2) {
				return "입력 오류 : " + e2.getMessage();
			}
		}
	}
	
	// 수정
	
	// 삭제
	
	
}
