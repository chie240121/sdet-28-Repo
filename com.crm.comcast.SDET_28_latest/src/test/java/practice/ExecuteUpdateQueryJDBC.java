package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ExecuteUpdateQueryJDBC {

	
		public static void main(String[] args) throws SQLException {
			
			//Register the driver
			
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			
			//Establish the database connection
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfo", "root", "root");
			
			//issue the create statement
			Statement statement = connection.createStatement();
			
			//execute the query
			int result = statement.executeUpdate("insert into student values(104 , 'frutiee' , 'sci');");
			
			if(result==1) {
				
				System.out.println("database has been updated");
				
			}
			else
				System.out.println("db has not been updated");
			
			//close the data base connection
			connection.close();

	}

}
