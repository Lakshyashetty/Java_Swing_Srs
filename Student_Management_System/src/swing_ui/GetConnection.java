package swing_ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
public static  Connection getConnection() {
	try {
		 Class.forName("com.mysql.jdbc.Driver");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	 Connection connection=null;
	 try {
		 connection=DriverManager.getConnection("jdbc:mysql://localhost:3307/user_m?useSSL=false&serverTimezone=UTC", "root", "");
		 System.out.println("connection created");
	} catch (Exception e) {
	
		e.printStackTrace();
	}
	 return connection;	
}
}
