package pack.model;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.MemBean;

@Repository
public class DataProcess {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapperInterface dataMapperInterface;  // hikari pool이 자동 지원
	
	// 전체 자료 읽기
	public List<MemDto> getDataAll(){
		List<MemDto> list = dataMapperInterface.selectAll();
		logger.info("전체 자료 크기 : " + list.size());
		return list;
	}
	
	// 부분 자료 읽기
	public MemDto getData(String num) {
		MemDto dto = dataMapperInterface.selectPart(num);
		return dto;
	}
	
	// 추가
	public boolean insert(MemBean bean) {
		// 번호 중복 방지 또는 번호 자동 증가 작업이 필요하나 장마비(2024년 7월 어느날) 땜시 생략...
		int re = dataMapperInterface.insertData(bean);
		if(re > 0)
			return true;
		else
			return false;
	}
	
	// 수정
	public boolean update(MemBean bean) {
		// 장마비(2024년 7월 어느날) 유심 사러 다녀옴. 쿠사리 먹음...
		int re = dataMapperInterface.updateData(bean);
		if(re > 0)
			return true;
		else
			return false;
	}
	
	// 삭제
	public boolean delete(String num) {
		int re = dataMapperInterface.deleteData(num);
		if(re > 0)
			return true;
		else
			return false;
	}
}