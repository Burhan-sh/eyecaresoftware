package EyeCare;
import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ClearHandler implements ActionListener {
    private JTextField[] textFields;
    private JDateChooser dateChoosers;

    public ClearHandler(JTextField[] clearJtextField, JDateChooser customerBdate) {
    	  this.textFields = clearJtextField;
          this.dateChoosers = customerBdate;
	}

	@Override
    public void actionPerformed(ActionEvent e) {
	     for (JTextField textField : textFields) {
	            textField.setText("");
	        }

	        dateChoosers.setDate(null);
    }
	
	public static void dataCleared( Map<String, JTextField> textFieldAll, JDateChooser dateChoosers ) {
		for (Map.Entry<String, JTextField> entry : textFieldAll.entrySet()) {
		    JTextField textField = entry.getValue();
		    textField.setText("");
		}
		 dateChoosers.setDate(null);
	}
}