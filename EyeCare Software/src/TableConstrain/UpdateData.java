package TableConstrain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class UpdateData {

	public UpdateData( JLabel cusID, Map<String , JTextField> textField , String Bdate , String gender , DefaultTableModel model , JScrollPane scrollPane ) {
		
		int id = Integer.parseInt( cusID.getText() );
		String name = textField.get("Name").getText();
		String Address = textField.get("Address").getText();
		String Contect_number = textField.get("Contact").getText();
		int age = Integer.parseInt( textField.get("Age").getText() );
		String examineBy = textField.get("Examined By").getText();
		
        Connection conn = null;
        PreparedStatement pstmt = null;
        int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to update data?", "Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirmation == JOptionPane.YES_OPTION) {
	        try {
	        	
	            String url = "jdbc:sqlite:sysconfig/EyeCare.db";
	            conn = DriverManager.getConnection(url);
	            
	            String sql = "UPDATE CustomerInfo SET Name = ?, ExaminedBy = ?, Address = ?, BirthDate = ?, ContectNo = ?, Gender = ?, Age = ? WHERE id = ?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, name);
	            pstmt.setString(2, examineBy);
	            pstmt.setString(3, Address);
	            pstmt.setString(4, Bdate);
	            pstmt.setString(5, Contect_number);
	            pstmt.setString(6, gender);
	            pstmt.setInt(7, age);
	            pstmt.setInt(8, id);
	            
	            pstmt.executeUpdate();
	            
		      for (int row = 0; row < model.getRowCount(); row++) {
		    	  String identity = model.getValueAt(row, 0).toString();
		          int ide = Integer.parseInt(identity);
		          if ( ide == id ) {
		        	  model.setValueAt(name, row, 1);
		        	  model.setValueAt(Address, row, 2);
		        	  model.setValueAt(Contect_number, row, 3);
		        	  model.setValueAt(examineBy, row, 4);
		        	  model.setValueAt(Bdate, row, 5);
		        	  model.setValueAt(gender, row, 6);
		        	  model.setValueAt(age, row, 7);
		          }
		      }
		      
	            JOptionPane.showMessageDialog(null, "Data Updated Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
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

}
