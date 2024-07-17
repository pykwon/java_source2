package pack.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
	@Autowired
	private DataMappingInterface mappingInterface;
	
	public List<JikwonDto> getDataAll(String jikwon_jik){
		List<JikwonDto> list = mappingInterface.selectDatas(jikwon_jik);
		return list;
	}
}
