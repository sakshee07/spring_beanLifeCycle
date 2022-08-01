package bean_life_cycle_annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
	public static Connection connection;
	

//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		StudentDAO studentDAO = new StudentDAO();
//		studentDAO.selectAllRows();
//		studentDAO.deletRecords(1);
//	}
//	
	public Connection getConnection() {
		StudentDAO studentDAO = new StudentDAO();

		try {
			connection = DriverManager.getConnection(studentDAO.url, studentDAO.username, studentDAO.password);
			if (connection != null) {
				System.out.println("Connected!");
			}
		} catch (SQLException e) {
			System.out.println("Exception occured : " + e);
		}
		return connection;
	}
}
