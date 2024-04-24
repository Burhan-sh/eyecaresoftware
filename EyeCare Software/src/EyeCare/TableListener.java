package EyeCare;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.toedter.calendar.JDateChooser;

import TableConstrain.GetPrescriptionData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class TableListener implements ListSelectionListener {

    private JTable table;
    private JTextField customerName;
    private JTextField customerAdd;
    private JTextField customerContect;
    private JTextField customerAge;
    private JTextField ExaminedBy;
    private JLabel cusID;
    private JLabel cusName;
    private JLabel cusNum;
    private JRadioButton genderMale;
    private JRadioButton genderFemale;
    private JDateChooser customerBdate;
    private JTextField prescriptionCustomerID;
    private DefaultTableModel pre_model;
    private Map<String, JTextField> textField;
    private Map<String, JLabel> insertJLabel;

    public TableListener(JTable table, JTextField customerName, JTextField customerAdd, JTextField customerContect,
                         JTextField customerAge, JTextField ExaminedBy, JLabel cusID2, JLabel cusName2,
                         JLabel cusNum2, JRadioButton genderMale, JRadioButton genderFemale,
                         JDateChooser customerBdate , JTextField prescriptionCustomerID, DefaultTableModel pre_model, Map<String, JTextField> insertData ,Map<String, JLabel> insertJLabel ) {
        this.table = table;
        this.customerName = customerName;
        this.customerAdd = customerAdd;
        this.customerContect = customerContect;
        this.customerAge = customerAge;
        this.ExaminedBy = ExaminedBy;
        this.cusID = cusID2;
        this.cusName = cusName2;
        this.cusNum = cusNum2;
        this.genderMale = genderMale;
        this.genderFemale = genderFemale;
        this.customerBdate = customerBdate;
        this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.prescriptionCustomerID = prescriptionCustomerID;
        this.pre_model = pre_model;
        this.textField = insertData;
        this.insertJLabel = insertJLabel;
    }

    @Override
    public void valueChanged(ListSelectionEvent event) {
        if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
        	
            int selectedRow = table.getSelectedRow();
            TableModel model = table.getModel();

            String ide = model.getValueAt(selectedRow, 0).toString();
            String name = model.getValueAt(selectedRow, 1).toString();
            String address = model.getValueAt(selectedRow, 2).toString();
            String contact = model.getValueAt(selectedRow, 3).toString();
            String examinedBy = model.getValueAt(selectedRow, 4).toString();
            String birthDateStr = model.getValueAt(selectedRow, 5).toString();
            String gender = model.getValueAt(selectedRow, 6).toString();
            String age = model.getValueAt(selectedRow, 7).toString();

            customerName.setText(name);
            customerAdd.setText(address);
            customerContect.setText(contact);
            customerAge.setText(age);
            ExaminedBy.setText(examinedBy);
            cusID.setText(ide);
            prescriptionCustomerID.setText(ide);
            cusName.setText(name);
            cusNum.setText(contact);
      //      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      //      table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
            
        	/* prescription model data Handel */
            
        	pre_model.setRowCount(0);
    		GetPrescriptionData preData = new GetPrescriptionData();
    		preData.setPrescriptionBadge(ide, pre_model, textField, insertJLabel , "forceReset");
            
        	/* end prescription model data Handel */
            
            try {
                Date date1 = new SimpleDateFormat("dd-MMM-yyyy").parse(birthDateStr);
                customerBdate.setDate(date1);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (gender.equalsIgnoreCase("male")) {
                genderMale.setSelected(true);
                genderFemale.setSelected(false);
            } else if (gender.equalsIgnoreCase("female")) {
                genderMale.setSelected(false);
                genderFemale.setSelected(true);
            }
        }
    }
}