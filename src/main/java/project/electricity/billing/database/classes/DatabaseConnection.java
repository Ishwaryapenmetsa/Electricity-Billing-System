package project.electricity.billing.database.classes;

import java.sql.*;

public class DatabaseConnection {

	Connection c;
	Statement s;
	
	public DatabaseConnection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			c =   DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
			s =   c.createStatement();
			
		}catch(Exception e) {
			
			System.out.println(e);
		}
		
	}
	
}
