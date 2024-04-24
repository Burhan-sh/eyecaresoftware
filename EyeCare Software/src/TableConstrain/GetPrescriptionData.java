package TableConstrain;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GetPrescriptionData {
	Connection conn = null;
    PreparedStatement pstmt = null;
    
    public GetPrescriptionData() {
    	String url = "jdbc:sqlite:EyeCare.db";
        try {
			this.conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    @SuppressWarnings("serial")
    public DefaultTableModel getColumData() {
    	DefaultTableModel model = new DefaultTableModel() {
    	    @Override
    	    public boolean isCellEditable(int row, int column) {
    	       return false;
    	    }
    	};
    	
    	model.addColumn("Prescription ID");
        model.addColumn("Order Date");
        model.addColumn("Customer ID");
        
    	return model;
    }

	public DefaultTableModel getModelData() {
    	
    	DefaultTableModel model = this.getColumData();
    	
        try {
        	
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM PrescritionDetails");
            
            while (rs.next()) {
            	model.addRow(new Object[]{rs.getString("PrescriptionID") , rs.getString("OrderDate") , rs.getString("CustomerId")});
            }
         
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    	return model;
    }
	
	public ResultSet getPresecriptionResult( String ide, Map<String, JTextField> insertData, Map<String, JLabel> insertLable ) {
		
		ResultSet result = null;
		try {
			Statement stmt = conn.createStatement();
			result = stmt.executeQuery("SELECT * FROM PrescritionDetails WHERE PrescriptionID = " + ide);
			getAndAnalisedData( result , insertData , insertLable );
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				result.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public void getChangeModelData(String cusID , DefaultTableModel model ) {
    	
		String query = "SELECT * FROM PrescritionDetails WHERE CustomerId = " + cusID ;
		
		model.setRowCount(0);

		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				model.addRow(new Object[]{rs.getString("PrescriptionID") , rs.getString("OrderDate") , rs.getString("CustomerId")});
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
    }
	
	public void setPrescriptionBadge( String cusID , DefaultTableModel model , Map<String, JTextField> insertData ,Map<String, JLabel> insertJLabel , String reSetField ) {
		this.getChangeModelData( cusID , model);
		String query = "SELECT * FROM PrescritionDetails WHERE CustomerId = " + cusID;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			if( ( rs.getString("PrescriptionID") ) != null ) {				
				while (rs.next()) {
					getAndAnalisedData( rs , insertData , insertJLabel );
				}
			}else {
				if( reSetField == "forceReset" ) {					
					resetAllTextField( insertData , insertJLabel );
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void getAndAnalisedData(ResultSet rs , Map<String, JTextField> insertData, Map<String, JLabel> insertJLabel ) {
		try {
			String prescriptionID = rs.getString("PrescriptionID");
			String sphOD = rs.getString("sphOD");
			String cylOD = rs.getString("cylOD");
			String axisOD = rs.getString("axisOD");
			String vdOD = rs.getString("vdOD");
			String nearOD = rs.getString("nearOD");
			String vnOD = rs.getString("vnOD");
			String sphOS = rs.getString("sphOS");
			String cylOS = rs.getString("cylOS");
			String axisOS = rs.getString("axisOS");
			String vdOS = rs.getString("vdOS");
			String nearOS = rs.getString("nearOS");
			String vnOS = rs.getString("vnOS");
			String LensType = rs.getString("LensType");
			String LensFor = rs.getString("LensFor");
			String LensSide = rs.getString("LensSide");
			String LensPrice = rs.getString("LensPrice");
			String FrameType = rs.getString("FrameType");
			String FramePrice = rs.getString("FramePrice");
			String PaidAmount = rs.getString("PaidAmount");
			String ExtraCharges = rs.getString("ExtraCharges");
			String Remark = rs.getString("Remark");
			String TotalAmount = rs.getString("TotalAmount");
			String CustomerId = rs.getString("CustomerId");
			
			// Assuming you have JTextField instances in the insertData map
			JTextField jsphOD = insertData.get("sphOD");
			JTextField jcylOD = insertData.get("cylOD");
			JTextField jaxisOD = insertData.get("axisOD");
			JTextField jvdOD = insertData.get("vdOD");
			JTextField jnearOD = insertData.get("nearOD");
			JTextField jvnOD = insertData.get("vnOD");
			JTextField jsphOS = insertData.get("sphOS");
			JTextField jcylOS = insertData.get("cylOS");
			JTextField jaxisOS = insertData.get("axisOS");
			JTextField jvdOS = insertData.get("vdOS");
			JTextField jnearOS = insertData.get("nearOS");
			JTextField jvnOS = insertData.get("vnOS");
			JTextField jLensType = insertData.get("LensType");
			JTextField jLensFor = insertData.get("LensFor");
			JTextField jLensSide = insertData.get("LensSide");
			JTextField jLensPrice = insertData.get("LensPrice");
			JTextField jFrameType = insertData.get("FrameType");
			JTextField jFramePrice = insertData.get("FramePrice");
			JTextField jPaidAmount = insertData.get("PaidAmount");
			JTextField jExtraCharges = insertData.get("ExtraCharges");
			JTextField jRemark = insertData.get("Remark");
			JTextField jTotalAmount = insertData.get("TotalAmount");
			JTextField jCustomerId = insertData.get("CustomerId");
			JTextField jPrescriptionID = insertData.get("txtPrescriptionID");
			
			jPrescriptionID.setText(prescriptionID);
			jsphOD.setText(sphOD);
			jcylOD.setText(cylOD);
			jaxisOD.setText(axisOD);
			jvdOD.setText(vdOD);
			jnearOD.setText(nearOD);
			jvnOD.setText(vnOD);
			jsphOS.setText(sphOS);
			jcylOS.setText(cylOS);
			jaxisOS.setText(axisOS);
			jvdOS.setText(vdOS);
			jnearOS.setText(nearOS);
			jvnOS.setText(vnOS);
			jLensType.setText(LensType);
			jLensFor.setText(LensFor);
			jLensSide.setText(LensSide);
			jLensPrice.setText(LensPrice);
			jFrameType.setText(FrameType);
			jFramePrice.setText(FramePrice);
			jPaidAmount.setText(PaidAmount);
			jExtraCharges.setText(ExtraCharges);
			jRemark.setText(Remark);
			jTotalAmount.setText(TotalAmount);
			jCustomerId.setText(CustomerId);
			
			JTextField txtODSPH = insertData.get("txtODSPH");
			JTextField txtODCYL = insertData.get("txtODCYL");
			JTextField txtODAXIS = insertData.get("txtODAXIS");
			JTextField txtODVD = insertData.get("txtODVD");
			JTextField txtODADD = insertData.get("txtODADD");
			JTextField txtODVN = insertData.get("txtODVN");
			JTextField txtOSSPH = insertData.get("txtOSSPH");
			JTextField txtOSCYL = insertData.get("txtOSCYL");
			JTextField txtOSAXIS = insertData.get("txtOSAXIS");
			JTextField txtOSVD = insertData.get("txtOSVD");
			JTextField txtOSADD = insertData.get("txtOSADD");
			JTextField txtOSVN = insertData.get("txtOSVN");
			JTextField txtLensPrice = insertData.get("txtLensPrice");
			JTextField txtFramePrice = insertData.get("txtFramePrice");
			JTextField txtTotalAmmount = insertData.get("txtTotalAmmount");
			JTextField txtPaidAmmount = insertData.get("txtPaidAmmount");
			
			JLabel lblLensType = insertJLabel.get( "lblLensType" );
			JLabel lblLensFor = insertJLabel.get( "lblLensFor" );
			JLabel lblLensSide = insertJLabel.get( "lblLensSide" );
			JLabel lblFrameType = insertJLabel.get( "lblFrameType" );

			Font boldFont = new Font(txtODSPH.getFont().getName(), Font.BOLD, txtODSPH.getFont().getSize());

			lblLensType.setText(LensType);
			lblLensFor.setText(LensFor);
			lblLensSide.setText(LensSide);
			lblFrameType.setText(FrameType);
			
			txtODSPH.setFont(boldFont);
			txtODSPH.setText(sphOD);
			txtODCYL.setFont(boldFont);
			txtODCYL.setText(cylOD);
			txtODAXIS.setFont(boldFont);
			txtODAXIS.setText(axisOD);
			txtODVD.setFont(boldFont);
			txtODVD.setText(vdOD);
			txtODADD.setFont(boldFont);
			txtODADD.setText(nearOD);
			txtODVN.setFont(boldFont);
			txtODVN.setText(vnOD);
			txtOSSPH.setFont(boldFont);
			txtOSSPH.setText(sphOS);
			txtOSCYL.setFont(boldFont);
			txtOSCYL.setText(cylOS);
			txtOSAXIS.setFont(boldFont);
			txtOSAXIS.setText(axisOS);
			txtOSVD.setFont(boldFont);
			txtOSVD.setText(vdOS);
			txtOSADD.setFont(boldFont);
			txtOSADD.setText(nearOS);
			txtOSVN.setFont(boldFont);
			txtOSVN.setText(vnOS);
			txtLensPrice.setFont(boldFont);
			txtLensPrice.setText(LensPrice);
			txtFramePrice.setFont(boldFont);
			txtFramePrice.setText(FramePrice);
			txtTotalAmmount.setFont(boldFont);
			txtTotalAmmount.setText(TotalAmount);
			txtPaidAmmount.setFont(boldFont);
			txtPaidAmmount.setText(PaidAmount);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void resetAllTextField( Map<String, JTextField> insertData , Map<String, JLabel> insertJLabel ) {
		// Assuming you have JTextField instances in the insertData map
		insertData.get("txtPrescriptionID").setText(null);
		insertData.get("sphOD").setText(null);
		insertData.get("cylOD").setText(null);
		insertData.get("axisOD").setText(null);
		insertData.get("vdOD").setText(null);
		insertData.get("nearOD").setText(null);
		insertData.get("vnOD").setText(null);
		insertData.get("sphOS").setText(null);
		insertData.get("cylOS").setText(null);
		insertData.get("axisOS").setText(null);
		insertData.get("vdOS").setText(null);
		insertData.get("nearOS").setText(null);
		insertData.get("vnOS").setText(null);
		insertData.get("LensType").setText(null);
		insertData.get("LensFor").setText(null);
		insertData.get("LensSide").setText(null);
		insertData.get("LensPrice").setText(null);
		insertData.get("FrameType").setText(null);
		insertData.get("FramePrice").setText(null);
		insertData.get("PaidAmount").setText(null);
		insertData.get("ExtraCharges").setText(null);
		insertData.get("Remark").setText(null);
		insertData.get("TotalAmount").setText(null);
		
		insertData.get("txtODSPH").setText("*****");
		insertData.get("txtODCYL").setText("*****");
		insertData.get("txtODAXIS").setText("*****");
		insertData.get("txtODVD").setText("*****");
		insertData.get("txtODADD").setText("*****");
		insertData.get("txtODVN").setText("*****");
		insertData.get("txtOSSPH").setText("*****");
		insertData.get("txtOSCYL").setText("*****");
		insertData.get("txtOSAXIS").setText("*****");
		insertData.get("txtOSVD").setText("*****");
		insertData.get("txtOSADD").setText("*****");
		insertData.get("txtOSVN").setText("*****");
		insertData.get("txtLensPrice").setText("*****");
		insertData.get("txtFramePrice").setText("*****");
		insertData.get("txtTotalAmmount").setText("*****");
		insertData.get("txtPaidAmmount").setText("*****");
		
		insertJLabel.get("lblLensType").setText("----");
		insertJLabel.get("lblLensFor").setText("----");
		insertJLabel.get("lblLensSide").setText("----");
		insertJLabel.get("lblFrameType").setText("----");
	}
	
}
