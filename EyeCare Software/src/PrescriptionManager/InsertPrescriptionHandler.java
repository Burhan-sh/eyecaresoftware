package PrescriptionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import EyeCare.DataValidation;
import EyeCare.ExtraFunctions;
import TableConstrain.InsertData;

public class InsertPrescriptionHandler implements ActionListener {
	
	private Map<String, JTextField> textField;
	private DefaultTableModel model;
	

	public InsertPrescriptionHandler(Map<String, JTextField> insertData, DefaultTableModel pre_model) {
		this.textField = insertData;
		this.model = pre_model;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ExtraFunctions extraFunction = new ExtraFunctions();
		String CurrentDate = extraFunction.updateDateLabel();
		
		automaticConfig( this.textField );
		
		Boolean dataValidation = validationConatiner(this.textField);
		if( dataValidation ) {
			 InsertData importTable = new InsertData();
			 importTable.InsertPrecriptions(textField, CurrentDate , model );	
	    }
	}
	
	public Boolean validationConatiner(Map<String, JTextField> textField) {
		for (Map.Entry<String, JTextField> entry : textField.entrySet()) {
		    String key = entry.getKey();
		    JTextField textField1 = entry.getValue();
		    String text = textField1.getText();
		    Boolean isNumeric = ( key=="LensPrice" || key=="FramePrice" || key=="PaidAmount" || key=="ExtraCharges" || key=="TotalAmount" ) ? true : false;
		    Boolean validation = validation(text,key,isNumeric);
		    if( validation == null || validation == false ) {
		    	return false;
		    }
		}
		return true;
	}
	
	public void automaticConfig( Map<String, JTextField> textField ) {
		for (Map.Entry<String, JTextField> entry : textField.entrySet()) {
		    String key = entry.getKey();
		    JTextField textField1 = entry.getValue();
		    String text = textField1.getText();
		    if( key == "PaidAmount" && text.equals("") ) {
		    	textField1.setText("0");
		    }
		    
		}
		
	}
	
	public Boolean validation( String value , String fieldName , Boolean isNumeric ) {
		Boolean result = true;
		
		if( isNumeric ) {				
			if( !DataValidation.isNumeric(value) ) {
				JOptionPane.showMessageDialog(null, fieldName + " required: Only numeric value allowed.", "Error", JOptionPane.ERROR_MESSAGE);
				result = false;
			}
		}
		return result;
	}

}
