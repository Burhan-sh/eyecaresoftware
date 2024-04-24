package PrescriptionManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import TableConstrain.GetPrescriptionData;

public class TablePrescriptionListner implements ListSelectionListener {
	
	private static final String String = null;
	private JTable table;
	private DefaultTableModel model;
	private Map<String, JTextField> insertData;
	private Map<String, JLabel> insertLable;

	public TablePrescriptionListner(JTable tablePrescription, DefaultTableModel pre_model,
			Map<String, JTextField> insertData, Map<String, JLabel> insertLable) {
		this.table = tablePrescription;
		this.model = pre_model;
		this.insertData = insertData;
		this.insertLable = insertLable;
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
			
			 int selectedRow = table.getSelectedRow();
	         TableModel model = table.getModel();

	         String ide = model.getValueAt(selectedRow, 0).toString();
	         
	         GetPrescriptionData getResult = new GetPrescriptionData();
	         getResult.getPresecriptionResult( ide , this.insertData , this.insertLable  );
	        
        }
	}

}
