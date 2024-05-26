package PrescriptionManager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class updatePrescriptionHandler implements ActionListener  {
	private Map<String, JTextField> insertData;
	private Map<String, JLabel> insertLable;
	public updatePrescriptionHandler( Map<String, JTextField> insertData, Map<String, JLabel> insertLable, DefaultTableModel pre_model ) {
		this.insertData = insertData;
		this.insertLable = insertLable;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String jsphOD = insertData.get("sphOD").getText();
		String jcylOD = insertData.get("cylOD").getText();
		String jaxisOD = insertData.get("axisOD").getText();
		String jvdOD = insertData.get("vdOD").getText();
		String jnearOD = insertData.get("nearOD").getText();
		String jvnOD = insertData.get("vnOD").getText();
		String jsphOS = insertData.get("sphOS").getText();
		String jcylOS = insertData.get("cylOS").getText();
		String jaxisOS = insertData.get("axisOS").getText();
		String jvdOS = insertData.get("vdOS").getText();
		String jnearOS = insertData.get("nearOS").getText();
		String jvnOS = insertData.get("vnOS").getText();
		String jLensType = insertData.get("LensType").getText();
		String jLensFor = insertData.get("LensFor").getText();
		String jLensSide = insertData.get("LensSide").getText();
		String jLensPrice = insertData.get("LensPrice").getText();
		String jFrameType = insertData.get("FrameType").getText();
		String jFramePrice = insertData.get("FramePrice").getText();
		String jPaidAmount = insertData.get("PaidAmount").getText();
		String jExtraCharges = insertData.get("ExtraCharges").getText();
		String jRemark = insertData.get("Remark").getText();
		String jTotalAmount = insertData.get("TotalAmount").getText();
		int jCustomerId = Integer.parseInt(insertData.get("CustomerId").getText());
		String jPrescriptionID = insertData.get("txtPrescriptionID").getText();
		
        Connection conn = null;
        PreparedStatement pstmt = null;
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to update data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
	        try {
	        	
	            String url = "jdbc:sqlite:EyeCare.db";
	            conn = DriverManager.getConnection(url);
	            
	            String sql = "UPDATE PrescritionDetails SET sphOD = ?, cylOD = ?, axisOD = ?, vdOD = ?, nearOD = ?, vnOD = ?, sphOS = ?"
	            		+ ", cylOS = ?, axisOS = ?, vdOS = ?, nearOS = ?, vnOS = ?, LensType = ?, LensFor = ?,"
	            		+ "LensSide = ?, LensPrice = ?, FrameType = ?, FramePrice = ?, PaidAmount = ?, ExtraCharges = ?,"
	            		+ "Remark = ?, TotalAmount = ?, CustomerId = ? WHERE PrescriptionID = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, jsphOD);
	            pstmt.setString(2, jcylOD);
	            pstmt.setString(3, jaxisOD);
	            pstmt.setString(4, jvdOD);
	            pstmt.setString(5, jnearOD);
	            pstmt.setString(6, jvnOD);
	            pstmt.setString(7, jsphOS);
	            pstmt.setString(8, jcylOS);
	            pstmt.setString(9, jaxisOS);
	            pstmt.setString(10, jvdOS);
	            pstmt.setString(11, jnearOS);
	            pstmt.setString(12, jvnOS);
	            pstmt.setString(13, jLensType);
	            pstmt.setString(14, jLensFor);
	            pstmt.setString(15, jLensSide);
	            pstmt.setString(16, jLensPrice);
	            pstmt.setString(17, jFrameType);
	            pstmt.setString(18, jFramePrice);
	            pstmt.setString(19, jPaidAmount);
	            pstmt.setString(20, jExtraCharges);
	            pstmt.setString(21, jRemark);
	            pstmt.setString(22, jTotalAmount);
	            pstmt.setInt(23, jCustomerId );
	            pstmt.setString(24, jPrescriptionID );
	            
	            int rowsAffected = pstmt.executeUpdate();

	            if (rowsAffected > 0) {
	            	setUpdatedData( insertData, insertLable );
	            }
	            
	            JOptionPane.showMessageDialog(null, "Data Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
	        } catch (SQLException e1) {
	            System.out.println(e1.getMessage());
	        } finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException e1) {
	                System.out.println(e1.getMessage());
	            }
	        }
        }
	}
	private void setUpdatedData( Map<String, JTextField> insertData, Map<String, JLabel> insertJLabel ) {
		
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

		lblLensType.setText(insertData.get("LensType").getText());
		lblLensFor.setText(insertData.get("LensFor").getText());
		lblLensSide.setText(insertData.get("LensSide").getText());
		lblFrameType.setText(insertData.get("FrameType").getText());
		
		txtODSPH.setFont(boldFont);
		txtODSPH.setText(insertData.get("sphOD").getText());
		txtODCYL.setFont(boldFont);
		txtODCYL.setText(insertData.get("cylOD").getText());
		txtODAXIS.setFont(boldFont);
		txtODAXIS.setText(insertData.get("axisOD").getText());
		txtODVD.setFont(boldFont);
		txtODVD.setText(insertData.get("vdOD").getText());
		txtODADD.setFont(boldFont);
		txtODADD.setText(insertData.get("nearOD").getText());
		txtODVN.setFont(boldFont);
		txtODVN.setText(insertData.get("vnOD").getText());
		txtOSSPH.setFont(boldFont);
		txtOSSPH.setText(insertData.get("sphOS").getText());
		txtOSCYL.setFont(boldFont);
		txtOSCYL.setText(insertData.get("cylOS").getText());
		txtOSAXIS.setFont(boldFont);
		txtOSAXIS.setText(insertData.get("axisOS").getText());
		txtOSVD.setFont(boldFont);
		txtOSVD.setText(insertData.get("vdOS").getText());
		txtOSADD.setFont(boldFont);
		txtOSADD.setText(insertData.get("nearOS").getText());
		txtOSVN.setFont(boldFont);
		txtOSVN.setText(insertData.get("vnOS").getText());
		txtLensPrice.setFont(boldFont);
		txtLensPrice.setText(insertData.get("LensPrice").getText());
		txtFramePrice.setFont(boldFont);
		txtFramePrice.setText(insertData.get("FramePrice").getText());
		txtTotalAmmount.setFont(boldFont);
		txtTotalAmmount.setText(insertData.get("TotalAmount").getText());
		txtPaidAmmount.setFont(boldFont);
		txtPaidAmmount.setText(insertData.get("PaidAmount").getText());
		
	}
}
