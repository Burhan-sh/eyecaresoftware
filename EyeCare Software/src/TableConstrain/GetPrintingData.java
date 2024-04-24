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
		ResultSet result = null;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery("SELECT * FROM PrescritionDetails WHERE PrescriptionID = " + ide);
			customerData = mapResultData(result);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				result.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return customerData;
	}
	
	public String[] mapResultData(ResultSet rs) {
	    String[] customerData = new String[31]; // Adjust the size according to the number of fields

	    try {
	        Statement stmt = conn.createStatement();
	        String CustomerId = rs.getString("CustomerId");

	        ResultSet crs = stmt.executeQuery("SELECT * FROM CustomerInfo WHERE id = " + CustomerId);

	        // Fetching customer information
	        customerData[0] = rs.getString("PrescriptionID");
	        customerData[1] = rs.getString("sphOD");
	        customerData[2] = rs.getString("cylOD");
	        customerData[3] = rs.getString("axisOD");
	        customerData[4] = rs.getString("vdOD");
	        customerData[5] = rs.getString("nearOD");
	        customerData[6] = rs.getString("vnOD");
	        customerData[7] = rs.getString("sphOS");
	        customerData[8] = rs.getString("cylOS");
	        customerData[9] = rs.getString("axisOS");
	        customerData[10] = rs.getString("vdOS");
	        customerData[11] = rs.getString("nearOS");
	        customerData[12] = rs.getString("vnOS");
	        customerData[13] = rs.getString("LensType");
	        customerData[14] = rs.getString("LensFor");
	        customerData[15] = rs.getString("LensSide");
	        customerData[16] = rs.getString("LensPrice");
	        customerData[17] = rs.getString("FrameType");
	        customerData[18] = rs.getString("FramePrice");
	        customerData[19] = rs.getString("PaidAmount");
	        customerData[20] = rs.getString("ExtraCharges");
	        customerData[21] = rs.getString("Remark");
	        customerData[22] = rs.getString("TotalAmount");

	        // Fetching customer's personal information
	        customerData[23] = crs.getString("Name");
	        customerData[24] = crs.getString("Address");
	        customerData[25] = crs.getString("ContectNo");
	        customerData[26] = crs.getString("ExaminedBy");
	        customerData[27] = crs.getString("BirthDate");
	        customerData[28] = crs.getString("Gender");
	        customerData[29] = String.valueOf(crs.getInt("Age"));
	        customerData[30] = rs.getString("CustomerId");

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return customerData;
	}

}
