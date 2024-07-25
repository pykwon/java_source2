package pack.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import jakarta.transaction.Transactional;
import pack.dto.MemberDto;
import pack.entity.Member;
import pack.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private MemberRepository memRepository;
	
	@Override
	public void getList(Model model) {
		/*
		// 방법1 : member 전체 자료 반환 : 기본 메소스 사용
		// Member 엔티티를 MemberDto 객체로 전달
		List<Member> entityList = memRepository.findAll();
		
		List<MemberDto> list = new ArrayList<MemberDto>();
		for(Member temp:entityList) {
			MemberDto dto = new MemberDto();
			dto.setNum(temp.getNum());
			dto.setName(temp.getName());
			dto.setAddr(temp.getAddr());
			list.add(dto);
		}
		*/
		
		// 방법2 : List<Member>를 Stream으로 변경해서 map()을 사용 List<MemberDto>로 변경하기
		List<MemberDto> list = memRepository
								.findAllByOrderByNumDesc()
								.stream()
								.map(item -> MemberDto.toDto(item)).toList();
		
		/*
		// 방법3 : 람다 표현식을 메소드 참조 표현식으로 기술   클래스명::메소드명
		List<MemberDto> list2 = memRepository
								.findAllByOrderByNumDesc()
								.stream()
								.map(MemberDto::toDto).toList();
		*/
		
		model.addAttribute("list", list); // 컨트롤러에 MemberDto가 담긴 list를 전달
	}
	
	@Override
	public void insert(MemberDto dto) {
		// Jpa 작업 영역 내로 들어 갈 때 일반 자료 전달용 (Dto, FormBean) 객체를 대응 엔티로로 변환
		memRepository.save(Member.toEntity(dto));
	}
	
	//수정 자료 읽기
	@Override
	public void getData(Long num, Model model) {
		// TODO Auto-generated method stub
		Member m = memRepository.findById(num).get();
		
		model.addAttribute("dto", MemberDto.toDto(m));
	}
	
	@Override
	public void update(MemberDto dto) {
		memRepository.save(Member.toEntity(dto));
	}
	
	@Transactional
	@Override
	public void update2(MemberDto dto) {
		// 수정할 회원의 번호를 이용해서 회원 정보 entity 객체 얻어내기
	    Member m1 = memRepository.findById(dto.getNum()).get();
	    Member m2 = memRepository.findById(dto.getNum()).get();
	    
	    // 동일성 검사
	    boolean isEqual = m1 == m2;
	    System.out.println("m1과 m2가 같냐?" + isEqual);
	    
	    // setter 메소드를 이용해서 이름과 주소 수정하기
	    m1.setName(dto.getName());
	    m1.setAddr(dto.getAddr());
	}
	
	@Override
	public void delete(Long num) {
		memRepository.deleteById(num);
	}
}
