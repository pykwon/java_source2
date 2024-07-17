package pack.model;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import pack.controller.FormBean;

@Mapper
public interface DataMappingInterface {
	@Select("select * from sangdata")
	List<SangpumDto> selectAll();
	
	@Select("select * from sangdata where sang like concat('%',#{searchValue},'%')")
	//@Select("select * from sangdata where sang like '%'||#{searchValue}||'%'")
	List<SangpumDto> selectSearch(FormBean bean);
}
