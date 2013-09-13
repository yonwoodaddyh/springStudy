package bitcho.user.dao;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
public class DAOFactory {
	@Bean
	public UserDAO userDAO() {
		UserDAO userDAO = new UserDAO();
		userDAO.setDataSource(dataSource());
		
		return userDAO;
	}

	@Bean
	private DataSource dataSource() {
		SimpleDriverDataSource datasource = new SimpleDriverDataSource();
		
		datasource.setDriverClass(com.mysql.jdbc.Driver.class);
		datasource.setUrl("jdbc:mysql://127.0.0.1/springbook");
		datasource.setUsername("dev");
		datasource.setPassword("dusdn1027");
		
		return datasource;
	}
}
