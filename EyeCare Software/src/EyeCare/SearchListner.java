package EyeCare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class SearchListner implements DocumentListener {
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private JTextField textField;
	private DefaultTableModel model;
	Connection conn = null;

	
	@SuppressWarnings("rawtypes")
	public SearchListner(JComboBox comboBox , JTextField textField , DefaultTableModel model) {
		this.comboBox = comboBox;
		this.textField = textField;
		this.model = model;
	}

	@Override
	public void insertUpdate(DocumentEvent e) {
		searchOpration(comboBox.getSelectedItem().toString() , textField.getText() );
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		searchOpration(comboBox.getSelectedItem().toString() , textField.getText() );
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		searchOpration(comboBox.getSelectedItem().toString() , textField.getText() );
	}

	public void searchOpration(String searchBy , String searchData ) {
		if( searchBy != "Search By" ) {			
			try {
				String url = "jdbc:sqlite:sysconfig/EyeCare.db";
				conn = DriverManager.getConnection(url);
				String query = "SELECT * FROM CustomerInfo WHERE " + searchBy + " LIKE '%" + searchData + "%'";
				
				model.setRowCount(0);
				
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					model.addRow(new Object[]{rs.getString("id") , rs.getString("Name"), rs.getString("Address"), rs.getString("ContectNo"), rs.getString("ExaminedBy"), rs.getString("BirthDate"), rs.getString("Gender"), rs.getInt("Age")});
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
