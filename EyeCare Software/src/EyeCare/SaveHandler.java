package EyeCare;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import java.util.Date;
import java.util.Enumeration;

import TableConstrain.InsertData;


public class SaveHandler implements ActionListener {
	
	private Map<String, JTextField> textField;
	private JDateChooser customerBdate;
	private ButtonGroup buttonGroup;
	private String formattedDate;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	
	public SaveHandler() {
		
	}

	public SaveHandler(Map<String, JTextField> save_data, JDateChooser customerBdate, ButtonGroup buttonGroup,DefaultTableModel modelMain,JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
		this.model = modelMain;
		this.buttonGroup = buttonGroup;
		this.textField = save_data;
		this.customerBdate = customerBdate;
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Boolean dataValidation = validationConatiner(this.textField , this.customerBdate);
		if( dataValidation ) {
			 String radioText = radioButtonData(this.buttonGroup);
			 InsertData importTable = new InsertData();
			 importTable.insertCustomer(textField, formattedDate , radioText , model ,scrollPane);
	    }
	}
	
	public Boolean validationConatiner( Map<String, JTextField> textField , JDateChooser customerBdate ) {
		DataValidation dataValidation = new DataValidation();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		Boolean finalValid = false;
		Boolean validation = false;
		
		for (Map.Entry<String, JTextField> entry : textField.entrySet()) {
		    String key = entry.getKey();
		    JTextField textField1 = entry.getValue();
		    String text = textField1.getText();
		    Boolean isNumeric = ( key=="Contact" || key=="Age" ) ? true : false;
		    Boolean extraValidation = ( key=="Contact" || key=="Age"  ) ? true : false;
		    validation = dataValidation.validation(text,key,isNumeric,extraValidation);
		    if( validation == null || validation == false ) {
		    	return finalValid;
		    }
		}
		
		Date date = ( customerBdate.getDate() != null ) ? customerBdate.getDate() : null;
		
		formattedDate = ( date != null ) ? dateFormat.format(date) : null;
		
		if( formattedDate == null && validation != null && validation != false ) {			
			JOptionPane.showMessageDialog(null, "Date : Please Enter Proper Date.", "Error", JOptionPane.ERROR_MESSAGE);
			finalValid = false;
		}
		
		if( formattedDate != null && validation != null ) {
			
			if (textField.containsKey("Name")) {
				String Name  = textField.get("Name").getText();
				String Address  = textField.get("Address").getText();
				String Contact  = textField.get("Contact").getText();
		        
		        Boolean dataEx = dataExists( Name , Address , Contact );
		        if(dataEx) {
		        	finalValid = true;
		        }else {
		        	int choice = JOptionPane.showConfirmDialog(null, "Data already exists. Do you want to proceed?", "Confirmation", JOptionPane.YES_NO_OPTION);
		        	 if (choice == JOptionPane.YES_OPTION) {
		                 finalValid = true; // User chose to proceed
		             } else {
		                 finalValid = false; // User chose not to proceed
		                 JOptionPane.showMessageDialog(null, "Data is not inserted please take note.", "Message", JOptionPane.INFORMATION_MESSAGE);
		                 ClearHandler.dataCleared(textField, customerBdate);
		             }
		        }
			}
		}
		return finalValid;
	}
	
	public String radioButtonData( ButtonGroup buttonGroup ) {
        JRadioButton selectedRadioButton = null;
        String radioText = null;
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                selectedRadioButton = (JRadioButton) button;
                break;
            }
        }
        if (selectedRadioButton != null) {
            String selectedText = selectedRadioButton.getText();
            radioText = selectedText;
        }
		return radioText;
	}
	
	public Boolean dataExists(String name , String address , String number) {
	    Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Boolean repeteData = null;

        String sql = "SELECT COUNT(*) FROM CustomerInfo WHERE Name = ? AND Address = ? AND ContectNo = ?";
        
        try {
        	
        	String url = "jdbc:sqlite:EyeCare.db";
            conn = DriverManager.getConnection(url);

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.setString(2, address);
            pstmt.setString(3, number);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                boolean isDuplicate = count > 0;
                
                if (isDuplicate) {
                	repeteData = false;
                } else {
                	repeteData = true;
                }
            }
            
        } catch (SQLException e) {
            System.out.println("Error checking data existence: " + e.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("Error closing connection: " + e.getMessage());
            }
        }
		return repeteData;
	}
	
}
