package TableConstrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.io.File;

public class DataManager {
	
    private static final String DB_URL_PREFIX = "jdbc:sqlite:";
    private static final String DB_FILENAME = "EyeCare.db";
    
	public DataManager() throws SQLException {
		DataManager.getConnection();
		new InsertData();
	}
	
    public static Connection getConnection() throws SQLException {
        boolean createDb = false;
        File dbFile = new File(DB_FILENAME);
        if (!dbFile.exists()) {
            createDb = true;
        }
        if (createDb) {
            createDatabase();
        }
        return DriverManager.getConnection(DB_URL_PREFIX + DB_FILENAME);
    }
	
    private static void createDatabase() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(DB_URL_PREFIX + DB_FILENAME);
            stmt = conn.createStatement();
            // Create Customer Table if it doesn't exist
            if (!tableExists(conn, "CustomerInfo")) {
                stmt.execute("CREATE TABLE CustomerInfo (id INTEGER PRIMARY KEY,Name TEXT,ExaminedBy TEXT,Address TEXT,BirthDate TEXT,ContectNo TEXT,Gender TEXT,Age INTEGER)");
            }
            
            if (!tableExists(conn, "PrescritionDetails")) {
                stmt.execute("CREATE TABLE PrescritionDetails (PrescriptionID INTEGER PRIMARY KEY,sphOD TEXT,cylOD TEXT,axisOD TEXT,vdOD TEXT,nearOD TEXT,vnOD TEXT,sphOS TEXT,cylOS TEXT,axisOS TEXT,vdOS TEXT,nearOS TEXT,vnOS TEXT,LensType TEXT,LensFor TEXT,LensSide TEXT,LensPrice TEXT,FrameType TEXT,FramePrice TEXT,PaidAmount TEXT,ExtraCharges TEXT,Remark TEXT,TotalAmount TEXT,CustomerId INTEGER,OrderDate TEXT)");
            }
            
//            if (!tableExists(conn, "userInfo")) {
//                stmt.execute("CREATE TABLE userInfo (user_id INTEGER PRIMARY KEY,username TEXT NOT NULL,password TEXT NOT NULL,user_role TEXT NOT NULL,mobile TEXT,email TEXT)");
//            }
            
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
    
    private static boolean tableExists(Connection conn, String tableName) throws SQLException {
        ResultSet rs = conn.getMetaData().getTables(null, null, tableName, null);
        try {
            return rs.next();
        } finally {
            if (rs != null) {
                rs.close();
            }
        }
    }
}
