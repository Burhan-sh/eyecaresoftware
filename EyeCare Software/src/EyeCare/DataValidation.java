package EyeCare;
import javax.swing.JOptionPane;

public class DataValidation {
	
	public Boolean validation( String value , String fieldName) {
		if( value.equals("") ) {
			JOptionPane.showMessageDialog(null, fieldName + " : field cannot be empty.", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
	
	public static boolean isNumeric(String str) {
		return str.matches("-?\\d+(\\.\\d+)?");
	}
	
	public Boolean validation( String value , String fieldName , Boolean isNumeric ) {
		Boolean notEmpty = validation( value , fieldName );
		Boolean result = null;
		if(notEmpty) {
			if( isNumeric ) {				
				if( !isNumeric(value) ) {
					JOptionPane.showMessageDialog(null, fieldName + " required: Only numeric value allowed.", "Error", JOptionPane.ERROR_MESSAGE);
					result = false;
				}else {
					if( fieldName=="Contact" && Double.parseDouble(value)<0 ) {
						JOptionPane.showMessageDialog(null, fieldName + " nagative: Nagative value is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
						result = false;
					}else if( fieldName!="Contact" && Integer.parseInt(value)<0 ) {
						JOptionPane.showMessageDialog(null, fieldName + " nagative: Nagative value is not allowed.", "Error", JOptionPane.ERROR_MESSAGE);
						result = false;
					}else {						
						result = true;
					}
				}
			}else {
				if( isNumeric(value) ) {
					JOptionPane.showMessageDialog(null, fieldName + " required: Not allowed numeric value.", "Error", JOptionPane.ERROR_MESSAGE);
					result = false;
				}else {
					result = true;
				}
			}
		}
		return result;
	}
	
	public Boolean validation( String value , String fieldName , Boolean isNumeric,Boolean extraValidation ) {
		Boolean completeValidation = validation( value , fieldName , isNumeric );
		Boolean extValidation = false;
		if(completeValidation != null && extraValidation && completeValidation != false ) {
			switch( fieldName ) {
				case "Age":
					extValidation = extraAgeValidation( value , fieldName );
					break;
				case "Contact":
					extValidation = extraContactValidation( value , fieldName );
					break;
				default:
					break;
			}
			return extValidation;
		}
		return completeValidation;
	}
	
	public Boolean extraAgeValidation( String value , String fieldName) {
		if( Integer.parseInt(value) < 0 || Integer.parseInt(value) >= 99 ) {
			JOptionPane.showMessageDialog(null, fieldName + " Age Between 1 TO 99 : Age must be 1 or Maximum 99", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {			
			return true;
		}
	}
	
	public Boolean extraContactValidation( String value , String fieldName) {
		if( Double.parseDouble(value) < 0 ) {
			JOptionPane.showMessageDialog(null, fieldName + "Nagative : Contect Nagative and 0 is not allowed", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}else {
			return true;
		}
	}
}
