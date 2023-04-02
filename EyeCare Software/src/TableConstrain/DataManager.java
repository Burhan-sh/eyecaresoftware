package TableConstrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataManager {
	
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DATABASE_URL = "jdbc:sqlite:mydatabase.db";
    
    private Connection conn;
    
	public DataManager() {
		  try {
	          Class.forName(JDBC_DRIVER);
	          conn = DriverManager.getConnection(DATABASE_URL);
	          System.out.println("Connection to SQLite database established!");
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	}

}
