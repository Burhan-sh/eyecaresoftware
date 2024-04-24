package EyeCare;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Map;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import TableConstrain.*;

public class UpdateHandler implements ActionListener {
	
	private Map<String, JTextField> textField;
	private JDateChooser customerBdate;
	private ButtonGroup buttonGroup;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private JLabel customerID;
	
	public UpdateHandler(JLabel cusID, Map<String, JTextField> save_data, JDateChooser customerBdate, ButtonGroup buttonGroup, DefaultTableModel modelMain , JScrollPane scrollPane) {
	
		this.customerID = cusID;
		this.model = modelMain;
		this.buttonGroup = buttonGroup;
		this.textField = save_data;
		this.customerBdate = customerBdate;
		this.scrollPane = scrollPane;
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		SaveHandler saveHandler = new SaveHandler();
		Boolean dataValidation = saveHandler.validationConatiner( this.textField , this.customerBdate);
		if( dataValidation ) {
			 String radioText = saveHandler.radioButtonData(this.buttonGroup);
			 SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
			 String formattedDate = dateFormat.format(this.customerBdate.getDate());
			 new UpdateData( customerID , textField , formattedDate , radioText , model , scrollPane);
	    }
	}
}
