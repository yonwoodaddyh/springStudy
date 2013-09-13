package bitcho.user.test;

import java.sql.SQLException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import bitcho.user.dao.CountingConnectionMaker;
import bitcho.user.dao.CountingDAOFactory;
import bitcho.user.dao.UserDAO;
import bitcho.user.domain.User;

public class UserDAOConnectionCountingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDAOFactory.class);
		UserDAO dao = context.getBean("userDAO", UserDAO.class);
		
		User user = new User();
		user.setId(args[0]);
		user.setName(args[1]);
		user.setPassword(args[2]);
		
		try {
			dao.add(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CountingConnectionMaker ccm = context.getBean("connectionMaker", CountingConnectionMaker.class);
		
		System.out.println("Connection counter : " + ccm.getCounter());
		
	}

}
