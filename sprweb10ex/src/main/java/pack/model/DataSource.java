package pack.model;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

@Component //init.xml에서 써야할 datasource DB 연결을 클래스파일로 따로 만듬
//@repository와 @component 둘 중에 하나를 아무거나 써도 됨 
public class DataSource extends DriverManagerDataSource{
	public DataSource() {
		setDriverClassName("org.mariadb.jdbc.Driver");
		setUrl("jdbc:mariadb://localhost:3306/test");
		setUsername("root");
		setPassword("123");
	}
	
}
