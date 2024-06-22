package TableConstrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GetPrintingData {
	
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    public GetPrintingData() {
    	String url = "jdbc:sqlite:EyeCare.db";
        try {
			this.conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
	public String[] getPresecriptionResult( String ide ) {
		String[] customerData = new String[31];
		try {
			customerData = mapResultData(ide);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return customerData;
	}
	
	public String[] mapResultData( String ide ) {
	    String[] customerData = new String[31];

	    try {
	        Statement stmt = conn.createStatement();
	        ResultSet crs = stmt.executeQuery("SELECT * FROM CustomerInfo WHERE id = " + ide);

	        // Fetching customer's personal information
	        customerData[23] = crs.getString("Name");
	        customerData[24] = crs.getString("Address");
	        customerData[25] = crs.getString("ContectNo");
	        customerData[26] = crs.getString("ExaminedBy");
	        customerData[27] = crs.getString("BirthDate");
	        customerData[28] = crs.getString("Gender");
	        customerData[29] = String.valueOf(crs.getInt("Age"));
	        customerData[30] = ide;

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return customerData;
	}
}
