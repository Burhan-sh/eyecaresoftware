package PrescriptionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class deletePrescriptionHandler implements ActionListener {
	private Map<String, JTextField> insertData;
	private DefaultTableModel pre_model;
	
	public deletePrescriptionHandler(Map<String, JTextField> insertData, DefaultTableModel pre_model) {
		this.insertData = insertData;
		this.pre_model = pre_model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		prescriptionDataManager( this.insertData );
	}
	
	private void prescriptionDataManager(Map<String, JTextField> insertData) {
		String prescriptionDataID = insertData.get( "txtPrescriptionID" ).getText();
		if ( !prescriptionDataID.isEmpty() ) {
			int confirmation = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this data?", "Confirmation", JOptionPane.YES_NO_OPTION);
	        if (confirmation == JOptionPane.YES_OPTION) {
	        	deleteData(Integer.parseInt(prescriptionDataID));
	        }
		}
	}
	
	private void deleteData( int prescriptionDataID ) {
	    PreparedStatement pstmt = null;
		String url = "jdbc:sqlite:EyeCare.db";
		Connection conn;
		try {
			conn = DriverManager.getConnection(url);
			String sql = "DELETE FROM PrescritionDetails WHERE PrescriptionID = ?";
			pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, prescriptionDataID);
	        int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
            	DefaultTableModel model = pre_model;
                int rowCount = model.getRowCount();
                for (int i = 0; i < rowCount; i++) {
                    String id = model.getValueAt(i, 0).toString();
                    int ide = Integer.parseInt(id);
                    if (ide == prescriptionDataID) {
                        model.removeRow(i);
                        break;
                    }
                }
            	JOptionPane.showMessageDialog(null, "Data Deleted Successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
}
