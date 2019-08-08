package connectJava;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB_Connection {
	
	public static void main(String[] args) {
		
		DB_Connection objDb_Connection = new DB_Connection();
		Connection connection = null;
		connection = objDb_Connection.getConnection();
		System.out.println(connection);
	
	}
	
	public static Connection getConnection() {
		
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");	
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteltourismservice", "root", "");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return connection;
	}
}
