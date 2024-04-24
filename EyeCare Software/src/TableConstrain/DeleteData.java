package TableConstrain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class DeleteData  implements ActionListener {
	private JLabel cusID;
	private DefaultTableModel model;
	
	public DeleteData(JLabel cusID, DefaultTableModel model) {
		this.cusID = cusID;
		this.model = model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cusIDText = cusID.getText();
		if( !cusIDText.equals("0") ) {	
			int customerID = Integer.parseInt(cusIDText);
			int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);
	        if (confirmation == JOptionPane.YES_OPTION) {
	        	deleteData(customerID);
	        }
		}
	}
	
	private void deleteData(int customerID ) {
		
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    try {	
			String url = "jdbc:sqlite:EyeCare.db";
			conn = DriverManager.getConnection(url);
			
			String sql = "DELETE FROM CustomerInfo WHERE id = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, customerID);
	        
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String id = model.getValueAt(i, 0).toString();
                    int ide = Integer.parseInt(id);
                    if (ide == customerID) {
                        model.removeRow(i);
                        break;
                    }
                }
            	JOptionPane.showMessageDialog(null, "Data Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
			
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
