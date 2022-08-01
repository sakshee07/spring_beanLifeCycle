package bean_life_cycle_annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentDAO {
	String driver;
	String url ;
	String password ;
	String username;

	void selectAllRows() throws ClassNotFoundException, SQLException {
		Test test = new Test();
		Connection connection = test.getConnection();

		Statement stmt = connection.createStatement();

		ResultSet rs = stmt.executeQuery("select * from HostelStudentInfo");

		while (rs.next()) {
			int studentId = rs.getInt(1);
			String studentName = rs.getString(2);
			int hostelFee = rs.getInt(3);
			String foodType = rs.getString(4);

			System.out.println(studentId + " " + studentName + " " + hostelFee + " " + foodType + " ");
		}
	}

	void deletRecords(int studentId) throws ClassNotFoundException, SQLException {
		Test test = new Test();
		Connection connection = test.getConnection();

		Statement stmt = connection.createStatement();

		 stmt.executeUpdate("delete from HostelStudentInfo where StudentId = "+ studentId);
		System.out.println("reord deleted for this id " );
	}
}

//		//load driver 	
//			Class.forName(driver);
//			
//			//get a connection
//			 Connection connection = DriverManager.getConnection(url, username, password);
//			 
//			 //execute code 		
//			Statement stmt = connection.createStatement();
//			
//			
//			 ResultSet rs =stmt.executeQuery("select * from ESnew.HosteStudentInfo");
//			
//			while(rs.next()) {
//				int studentId = rs.getInt(1);
//				String studentName = rs.getString(2);
//				int hostelFee = rs.getInt(3);
//				String foodType = rs.getString(4);
//				
//				System.out.println(studentId + " " + studentName +" "+hostelFee + " "+ foodType + " ");
//			}
