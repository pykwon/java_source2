package pack.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.model.DataInterface;
import pack.model.MemDto;

@Service
public class BusinessImpl implements BusinessInter{
	@Autowired
	private DataInterface dataInterface;
	
	@Override
	public void dataPrint() {
		List<MemDto> mlist = dataInterface.selectDataAll();
		
		System.out.println("dataPrint 메소드에서 출력");
		for(MemDto m : mlist) {
			System.out.println(m.getNum() + " " + 
					m.getName() + " " + 
					m.getAddr());
		}
	}
}
