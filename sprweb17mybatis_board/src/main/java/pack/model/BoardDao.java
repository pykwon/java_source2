package pack.model;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import pack.controller.BoardBean;

@Repository
public class BoardDao {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private DataMapInterface mapInterface;
	
	public List<Board> list(){
		List<Board> list = null;
		try {
			list = mapInterface.selectList();
		} catch (Exception e) {
			logger.info("list err : " + e);
		}
		return list;
	}
	
	public boolean insertData(BoardBean bean) {
		boolean b = false;
		int re = mapInterface.insert(bean);
		if(re > 0) b = true;
		return b;
	}
	
	public List<Board> search(BoardBean bean){
		List<Board> slist = mapInterface.selectSearch(bean);
		return slist;
	}
	
	public Board detail(String num) {
		// 조회수 증가 후 상세보기 처리
		mapInterface.updateReadcnt(num);
		
		Board board = mapInterface.selectOne(num);
		return board;
	}
	
	public boolean updateData(BoardBean bean) {
		boolean b = false;
		int re = mapInterface.update(bean);
		if(re > 0) b = true;
		return b;
	}
	
	public boolean deleteData(BoardBean bean) {
		boolean b = false;
		int re = mapInterface.delete(Integer.toString(bean.getNum()));
		if(re > 0) b = true;
		return b;
	}
}
