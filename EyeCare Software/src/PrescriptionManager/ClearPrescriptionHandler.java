package PrescriptionManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JTextField;

public class ClearPrescriptionHandler implements ActionListener {
	
	private Map<String, JTextField> insertData;

	public ClearPrescriptionHandler(Map<String, JTextField> insertData) {
		this.insertData = insertData;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		setFieldTemplate(this.insertData);
		
	}

	private void setFieldTemplate( Map<String, JTextField> insertData ) {
		// Assuming you have JTextField instances in the insertData map
		insertData.get("txtPrescriptionID").setText(null);
		insertData.get("sphOD").setText(null);
		insertData.get("cylOD").setText(null);
		insertData.get("axisOD").setText(null);
		insertData.get("vdOD").setText(null);
		insertData.get("nearOD").setText(null);
		insertData.get("vnOD").setText(null);
		insertData.get("sphOS").setText(null);
		insertData.get("cylOS").setText(null);
		insertData.get("axisOS").setText(null);
		insertData.get("vdOS").setText(null);
		insertData.get("nearOS").setText(null);
		insertData.get("vnOS").setText(null);
		insertData.get("LensType").setText(null);
		insertData.get("LensFor").setText(null);
		insertData.get("LensSide").setText(null);
		insertData.get("LensPrice").setText(null);
		insertData.get("FrameType").setText(null);
		insertData.get("FramePrice").setText(null);
		insertData.get("PaidAmount").setText(null);
		insertData.get("ExtraCharges").setText(null);
		insertData.get("Remark").setText(null);
		insertData.get("TotalAmount").setText(null);	
	} 
	
}
