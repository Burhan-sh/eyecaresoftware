package TableConstrain;

import java.awt.Rectangle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JTable;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class InsertData {
	
	public void insertCustomer( Map<String , JTextField> textField , String Bdate , String gender , DefaultTableModel model , JScrollPane scrollPane ) {
		
		String name = textField.get("Name").getText();
		String Address = textField.get("Address").getText();
		String Contect_number = textField.get("Contact").getText();
		int age = Integer.parseInt( textField.get("Age").getText() );
		String examineBy = textField.get("Examined By").getText();
		
        Connection conn = null;
        PreparedStatement pstmt = null;
        
        try {
        	
            String url = "jdbc:sqlite:EyeCare.db";
            conn = DriverManager.getConnection(url);

            String sql = "INSERT INTO CustomerInfo (Name,ExaminedBy,Address,BirthDate,ContectNo,Gender,Age) VALUES (?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, examineBy);
            pstmt.setString(3, Address);
            pstmt.setString(4, Bdate);
            pstmt.setString(5, Contect_number);
            pstmt.setString(6, gender);
            pstmt.setInt(7, age);
            
            JTable table = new JTable();
            
            int affectedRows = pstmt.executeUpdate();
            
            if (affectedRows > 0) {
      
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                	long insertedId = rs.getLong(1);
                	Object[] newRow = {insertedId , name, Address, Contect_number, examineBy,  Bdate,  gender, age};
                	model.addRow(newRow);
                	table.setModel(model);
                	table.repaint();
                	
                	Rectangle rect = table.getCellRect(table.getRowCount() - 1, 0, true);
                	scrollPane.getViewport().scrollRectToVisible(rect);
                }
            }

            JOptionPane.showMessageDialog(null, "Data Inserted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
	
	public void InsertPrecriptions( Map<String , JTextField> textField , String CurrentDate, DefaultTableModel model ) {
		
		String sphOD = textField.get("sphOD").getText();
		String cylOD = textField.get("cylOD").getText();
		String axisOD = textField.get("axisOD").getText();
		String vdOD = textField.get("vdOD").getText();
		String nearOD = textField.get("nearOD").getText();
		String vnOD = textField.get("vnOD").getText();
		String sphOS = textField.get("sphOS").getText();
		String cylOS = textField.get("cylOS").getText();
		String axisOS = textField.get("axisOS").getText();
		String vdOS = textField.get("vdOS").getText();
		String nearOS = textField.get("nearOS").getText();
		String vnOS = textField.get("vnOS").getText();
		String LensType = textField.get("LensType").getText();
		String LensFor = textField.get("LensFor").getText();
		String LensSide = textField.get("LensSide").getText();
		String LensPrice = textField.get("LensPrice").getText();
		String FrameType = textField.get("FrameType").getText();
		String FramePrice = textField.get("FramePrice").getText();
		String PaidAmount = textField.get("PaidAmount").getText();
		String ExtraCharges = textField.get("ExtraCharges").getText();
		String Remark = textField.get("Remark").getText();
		String TotalAmount = textField.get("TotalAmount").getText();
		int CustomerId = Integer.parseInt( textField.get("CustomerId").getText() );
		
		Connection conn = null;
	    PreparedStatement pstmt = null;
	        
        try {
        	
            String url = "jdbc:sqlite:EyeCare.db";
            conn = DriverManager.getConnection(url);

            String sql = "INSERT INTO PrescritionDetails (sphOD,cylOD,axisOD,vdOD,nearOD,vnOD,sphOS,cylOS,axisOS,vdOS,nearOS,vnOS,LensType,LensFor,LensSide,LensPrice,FrameType,FramePrice,PaidAmount,ExtraCharges,Remark,TotalAmount,CustomerId,OrderDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, sphOD);
            pstmt.setString(2, cylOD);
            pstmt.setString(3, axisOD);
            pstmt.setString(4, vdOD);
            pstmt.setString(5, nearOD);
            pstmt.setString(6, vnOD);
            pstmt.setString(7, sphOS);
            pstmt.setString(8, cylOS);
            pstmt.setString(9, axisOS);
            pstmt.setString(10, vdOS);
            pstmt.setString(11, nearOS);
            pstmt.setString(12, vnOS);
            pstmt.setString(13, LensType);
            pstmt.setString(14, LensFor);
            pstmt.setString(15, LensSide);
            pstmt.setString(16, LensPrice);
            pstmt.setString(17, FrameType);
            pstmt.setString(18, FramePrice);
            pstmt.setString(19, PaidAmount);
            pstmt.setString(20, ExtraCharges);
            pstmt.setString(21, Remark);
            pstmt.setString(22, TotalAmount);
            pstmt.setInt(23, CustomerId);
            pstmt.setString(24, CurrentDate);
             
            pstmt.executeUpdate();
            
            GetPrescriptionData preData = new GetPrescriptionData();
            preData.getChangeModelData(textField.get("CustomerId").getText() , model);

            JOptionPane.showMessageDialog(null, "Data Inserted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
       }
	}
	


}
