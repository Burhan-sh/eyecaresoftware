package EyeCare;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Insets;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridLayout;

import java.awt.Image;


import javax.swing.ImageIcon;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import com.toedter.calendar.JDateChooser;

import PrescriptionManager.*;

import javax.imageio.ImageIO;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.Label;
import java.awt.SystemColor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import java.util.LinkedHashMap;
import java.util.Map;

import TableConstrain.*;


public class main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ButtonGroup buttonGroup = new ButtonGroup();
	public JTable table;
	private JTextField txtODSPH;
	private JTextField txtLensPrice;
	private JTextField txtTotalAmmount;
	private JTextField txtFramePrice;
	private JTextField txtODCYL;
	private JTextField txtODAXIS;
	private JTextField txtODVD;
	private JTextField txtODADD;
	private JTextField txtODVN;
	private JTextField txtOSSPH;
	private JTextField txtOSCYL;
	private JTextField txtOSAXIS;
	private JTextField txtOSVD;
	private JTextField txtOSADD;
	private JTextField txtOSVN;
	private JTextField customerName;
	private JTextField customerAdd;
	private JTextField customerContect;
	private JTextField customerAge;
	private JTextField ExaminedBy;
	private JTextField searchField;
	private JTextField txtPrescriptionID;
	private JPanel panel_5;
	private JTextField rightSPH;
	private JTextField rightCYL;
	private JTextField rightAxis;
	private JTextField rightVD;
	private JTextField rightNear;
	private JTextField rightVN;
	private JTextField leftSPH;
	private JTextField leftCYL;
	private JTextField leftAxis;
	private JTextField leftVD;
	private JTextField leftNear;
	private JTextField leftVN;
	private JTextField lensType;
	private JTextField lensFor;
	private JTextField lensSide;
	private JTextField lensPrice;
	private JTextField frameType;
	private JTextField framePrice;
	private JTextField paidAmount;
	private JTextField extraCharges;
	private JTextField remark;
	private JTextField totalAmount;
	private JTable tablePrescription;
	public JLabel cusID;

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(75, 75, 1201, 755);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setMargin(new Insets(3, 3, 3, 3));
		mnNewMenu.setActionCommand("Home");
		menuBar.add(mnNewMenu);
		
		GetCustmerData getData = new GetCustmerData();
		
		DefaultTableModel model = getData.getModelData();
				
		table = new JTable(model);
		
		new ExtraFunctions(table , model);
		
		table.getTableHeader();
		
		JMenuItem mntmNewMenuItem = new JMenuItem("File");
		mntmNewMenuItem.setAlignmentX(Component.LEFT_ALIGNMENT);
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		
		JPanel secondFromPane = new JPanel();
		secondFromPane.setBorder(new TitledBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Lens Details of Customer", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), "Lens Details Of Customer", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JPanel panel_3 = new JPanel();
		
		panel_3.setBorder(new TitledBorder(null, "Patient History", TitledBorder.LEADING, TitledBorder.TOP, null, null));
	
		JPanel norContainer = new JPanel();
	
		 JLabel resizedLabel = ExtraFunctions.resizeImage(800, 100);
		norContainer.add(resizedLabel);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(norContainer, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addComponent(secondFromPane, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(tabbedPane, 0, 0, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(secondFromPane, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(norContainer, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
		);
		norContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_3.setLayout(new MigLayout("", "[][][][][][][][]", "[][]"));
		
		JLabel lblNewLabel_10 = new JLabel("Search Patient");
		panel_3.add(lblNewLabel_10, "cell 0 0,alignx trailing");
		
		searchField = new JTextField();
		panel_3.add(searchField, "cell 1 0");
		searchField.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		panel_3.add(comboBox, "cell 2 0");
		
		ExtraFunctions extraFunc = new ExtraFunctions();
		extraFunc.searchByFunc(comboBox);
		
		searchField.getDocument().addDocumentListener(new SearchListner( comboBox , searchField , model ));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("(+)Add New Information", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[grow][grow]25[]25[][][][]", "[]15[]15[]15[]15[]15[]15[]15[]20[]"));
		
		JLabel lblNewLabel = new JLabel("Name");
		panel_1.add(lblNewLabel, "cell 0 1");
		
		customerName = new JTextField();
		panel_1.add(customerName, "cell 1 1");
		customerName.setColumns(10);
		
		
		JLabel lblNewLabel_3 = new JLabel("Examined By");
		panel_1.add(lblNewLabel_3, "cell 3 1");
		
		ExaminedBy = new JTextField();
		ExaminedBy.setColumns(10);
		panel_1.add(ExaminedBy, "cell 4 1");
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		panel_1.add(lblNewLabel_1, "cell 0 2");
		
		customerAdd = new JTextField();
		customerAdd.setColumns(10);
		panel_1.add(customerAdd, "cell 1 2");
		
		JLabel lblNewLabel_1_1 = new JLabel("Bithdate");
		panel_1.add(lblNewLabel_1_1, "cell 3 2");
		
		JDateChooser customerBdate = new JDateChooser();
		panel_1.add( customerBdate , "cell 4 2,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Contect No");
		panel_1.add(lblNewLabel_2, "cell 0 3");
		
		customerContect = new JTextField();
		customerContect.setColumns(10);
		panel_1.add(customerContect, "cell 1 3");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Gender");
		panel_1.add(lblNewLabel_2_1_1, "cell 3 3");
		
		JRadioButton genderMale = new JRadioButton("Male");
		panel_1.add(genderMale, "flowx,cell 4 3");
		genderMale.setSelected(true);
		
		JLabel lblNewLabel_2_1 = new JLabel("Age");
		panel_1.add(lblNewLabel_2_1, "cell 0 4");
		
		customerAge = new JTextField();
		customerAge.setColumns(10);
		panel_1.add(customerAge, "cell 1 4");
		
		JButton save_btn = new JButton("Save");
		save_btn.setPreferredSize(new Dimension(120, 30));
		panel_1.add(save_btn, "cell 0 6 7 1,alignx center");
		Map<String, JTextField> save_data = new LinkedHashMap<String, JTextField>();
		save_data.put("Name",customerName);
		save_data.put("Address",customerAdd);
		save_data.put("Contact",customerContect);
		save_data.put("Age",customerAge);
		save_data.put("Examined By",ExaminedBy);
		
		save_btn.addActionListener(new SaveHandler(save_data, customerBdate , buttonGroup , model ,scrollPane ));
		
		JButton clear_btn = new JButton("Clear");
		clear_btn.setPreferredSize(new Dimension(120, 30));
		panel_1.add(clear_btn, "cell 0 6 7 1,alignx center");
		
		JTextField [] clearJtextField = { customerName, customerAdd , customerContect , customerAge , ExaminedBy };
		
		clear_btn.addActionListener( new ClearHandler( clearJtextField , customerBdate ) );
		
		JButton update_btn = new JButton("Update");
		update_btn.setPreferredSize(new Dimension(120, 30));
		panel_1.add(update_btn, "cell 0 6 7 1,alignx center");
		
		JButton delete_btn = new JButton("Delete");
		delete_btn.setPreferredSize(new Dimension(120, 30));
		panel_1.add(delete_btn, "cell 0 6 7 1,alignx center");
		
		JRadioButton genderFemale = new JRadioButton("Female");
		panel_1.add(genderFemale, "cell 4 3");
		
		buttonGroup.add(genderMale);
		buttonGroup.add(genderFemale);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add New Prescription", null, panel_2, null);
		tabbedPane.setEnabledAt(1, false);
		
		   table.addMouseListener(new MouseAdapter() {
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                if (e.getClickCount() == 2) {
	                    tabbedPane.setEnabledAt(1, true);
	                    tabbedPane.setSelectedIndex(1);
	                }
	            }
	        });
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.PINK);
		
		panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.scrollbar);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
				.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		GetPrescriptionData preData = new GetPrescriptionData();
		DefaultTableModel pre_model = preData.getModelData();
		tablePrescription = new JTable(pre_model);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1);
		scrollPane_1.setViewportView(tablePrescription);
		panel_5.setLayout(null);
		
		Panel panel_7 = new Panel();
		panel_7.setBounds(10, 10, 397, 83);
		panel_5.add(panel_7);
		panel_7.setLayout(new MigLayout("", "[62px][][][][][][]", "[22px][][][][][][][][][]"));
		
		Label label = new Label("Eye");
		panel_7.add(label, "cell 0 0,alignx left,aligny top");
		
		Label label_1 = new Label("SPH");
		panel_7.add(label_1, "cell 1 0");
		
		Label label_2 = new Label("CYL");
		panel_7.add(label_2, "cell 2 0");
		
		Label label_3 = new Label("AXIS");
		panel_7.add(label_3, "cell 3 0");
		
		Label label_4 = new Label("VD");
		panel_7.add(label_4, "cell 4 0");
		
		Label label_6 = new Label("NEAR");
		panel_7.add(label_6, "cell 5 0");
		
		Label label_5 = new Label("VN");
		panel_7.add(label_5, "cell 6 0");
		
		Label label_7 = new Label("OD(Right)");
		panel_7.add(label_7, "cell 0 1");
		
		rightSPH = new JTextField();
		panel_7.add(rightSPH, "cell 1 1");
		rightSPH.setColumns(10);
		
		rightCYL = new JTextField();
		panel_7.add(rightCYL, "cell 2 1");
		rightCYL.setColumns(10);
		
		rightAxis = new JTextField();
		panel_7.add(rightAxis, "cell 3 1");
		rightAxis.setColumns(10);
		
		rightVD = new JTextField();
		panel_7.add(rightVD, "cell 4 1");
		rightVD.setColumns(10);
		
		rightNear = new JTextField();
		panel_7.add(rightNear, "cell 5 1");
		rightNear.setColumns(10);
		
		rightVN = new JTextField();
		panel_7.add(rightVN, "cell 6 1");
		rightVN.setColumns(10);
		
		Label label_8 = new Label("OS(Left)");
		panel_7.add(label_8, "cell 0 2");
		
		leftSPH = new JTextField();
		leftSPH.setColumns(10);
		panel_7.add(leftSPH, "cell 1 2");
		
		leftCYL = new JTextField();
		leftCYL.setColumns(10);
		panel_7.add(leftCYL, "cell 2 2");
		
		leftAxis = new JTextField();
		leftAxis.setColumns(10);
		panel_7.add(leftAxis, "cell 3 2");
		
		leftVD = new JTextField();
		leftVD.setColumns(10);
		panel_7.add(leftVD, "cell 4 2");
		
		leftNear = new JTextField();
		leftNear.setColumns(10);
		panel_7.add(leftNear, "cell 5 2");
		
		leftVN = new JTextField();
		leftVN.setColumns(10);
		panel_7.add(leftVN, "wrap");
		
		Panel panel_8 = new Panel();
		panel_8.setBounds(10, 99, 397, 142);
		panel_5.add(panel_8);
		panel_8.setLayout(new MigLayout("", "[][grow][][][][][grow]", "[][][][][]"));
		
		Label label_9 = new Label("Lens Type");
		panel_8.add(label_9, "cell 0 0");
		
		lensType = new JTextField();
		panel_8.add(lensType, "cell 1 0");
		lensType.setColumns(10);
		
		Label label_10 = new Label("Lens For");
		panel_8.add(label_10, "cell 5 0");
		
		lensFor = new JTextField();
		panel_8.add(lensFor, "cell 6 0,growx");
		lensFor.setColumns(10);
		
		Label label_9_1 = new Label("Lens Side");
		panel_8.add(label_9_1, "cell 0 1");
		
		lensSide = new JTextField();
		lensSide.setColumns(10);
		panel_8.add(lensSide, "cell 1 1,growx");
		
		Label label_10_1 = new Label("Lens Price");
		panel_8.add(label_10_1, "cell 5 1");
		
		lensPrice = new JTextField();
		lensPrice.setColumns(10);
		panel_8.add(lensPrice, "cell 6 1,growx");
		
		Label label_9_1_1 = new Label("Frame Type");
		panel_8.add(label_9_1_1, "cell 0 2");
		
		frameType = new JTextField();
		frameType.setColumns(10);
		panel_8.add(frameType, "cell 1 2,growx");
		
		Label label_10_1_1 = new Label("Frame Price");
		panel_8.add(label_10_1_1, "cell 5 2");
		
		framePrice = new JTextField();
		framePrice.setColumns(10);
		panel_8.add(framePrice, "cell 6 2,growx");
		
		Label label_11 = new Label("Paid Amount");
		panel_8.add(label_11, "cell 0 3");
		
		paidAmount = new JTextField();
		panel_8.add(paidAmount, "cell 1 3,growx");
		paidAmount.setColumns(10);
		
		Label label_12 = new Label("Extra Charges");
		panel_8.add(label_12, "cell 5 3");
		
		extraCharges = new JTextField();
		panel_8.add(extraCharges, "cell 6 3,growx");
		extraCharges.setColumns(10);
		
		Label label_13 = new Label("Remark");
		panel_8.add(label_13, "cell 0 4");
		
		remark = new JTextField();
		remark.setText("");
		panel_8.add(remark, "cell 1 4,growx");
		remark.setColumns(10);
		
		Label label_14 = new Label("Total amount");
		panel_8.add(label_14, "cell 5 4");
		
		totalAmount = new JTextField();
		panel_8.add(totalAmount, "cell 6 4,growx");
		totalAmount.setColumns(10);
		
		Panel panel_9 = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		panel_9.setBounds(10, 247, 397, 46);
		panel_5.add(panel_9);
		
		JButton prescripInsertBtn = new JButton("Insert");
		panel_9.add(prescripInsertBtn);	
		
		JButton prescripUpdateBtn = new JButton("Update");
	
		panel_9.add(prescripUpdateBtn);
		
		JButton prescripClearBtn = new JButton("Clear");
		panel_9.add(prescripClearBtn);
		
	
		
		JButton prescripDeleteBtn = new JButton("Delete");
		panel_9.add(prescripDeleteBtn);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_11 = new JLabel("Customer ID");
		panel_4.add(lblNewLabel_11);
		
		JTextField prescriptionCustomerID = new JTextField("1255");
		prescriptionCustomerID.setColumns(3);
		prescriptionCustomerID.setEditable(false);
		prescriptionCustomerID.setForeground(Color.DARK_GRAY);
		panel_4.add(prescriptionCustomerID);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_4.add(horizontalStrut);
		
		JLabel lblNewLabel_12 = new JLabel("Prescription ID");
		panel_4.add(lblNewLabel_12);
		
		txtPrescriptionID = new JTextField();
		txtPrescriptionID.setEditable(false);
		panel_4.add(txtPrescriptionID);
		txtPrescriptionID.setColumns(10);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Priscription", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Customer ID :");
		
		cusID = new JLabel("0");
		
		JLabel lblNewLabel_4_1 = new JLabel("Name : ");
		
		JLabel cusName = new JLabel("");
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Contect No :");
		
		JLabel cusNum = new JLabel("");
		GroupLayout gl_secondFromPane = new GroupLayout(secondFromPane);
		gl_secondFromPane.setHorizontalGroup(
			gl_secondFromPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_secondFromPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_secondFromPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_secondFromPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cusID)
							.addGap(43)
							.addComponent(lblNewLabel_4_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cusName)
							.addGap(30)
							.addComponent(lblNewLabel_4_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(cusNum, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_secondFromPane.setVerticalGroup(
			gl_secondFromPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_secondFromPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_secondFromPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(cusID)
						.addComponent(lblNewLabel_4_1)
						.addComponent(cusName)
						.addComponent(lblNewLabel_4_1_1)
						.addComponent(cusNum))
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 235, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(20, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_7 = new JLabel("Distance");
		
		JLabel lblNewLabel_7_1 = new JLabel("OD(Right)");
		
		JLabel lblNewLabel_7_2 = new JLabel("OS(Left) ");
		
		JLabel lblNewLabel_7_3 = new JLabel("SPH.");
		
		JLabel lblNewLabel_7_4 = new JLabel("CYL");
		
		JLabel lblNewLabel_7_5 = new JLabel("AXIS");
		
		JLabel lblNewLabel_7_6 = new JLabel("VD");
		
		JLabel lblNewLabel_7_7 = new JLabel("NEAR ADD");
		
		JLabel lblNewLabel_7_8 = new JLabel("VN");
		
		txtODSPH = new JTextField();
		txtODSPH.setEditable(false);
		txtODSPH.setText("*****");
		txtODSPH.setHorizontalAlignment(SwingConstants.CENTER);
		txtODSPH.setBackground(new Color(255, 255, 240));
		txtODSPH.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Lens Type");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_8_1 = new JLabel("Lens For");
		lblNewLabel_8_1.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_8_2 = new JLabel("Lens Side");
		lblNewLabel_8_2.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_8_3 = new JLabel("Frame Type");
		lblNewLabel_8_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblLensType = new JLabel("----");
		
		JLabel lblLensFor = new JLabel("----");
		
		JLabel lblLensSide = new JLabel("----");
		
		JLabel lblFrameType = new JLabel("----");
		
		JLabel lblNewLabel_8_7 = new JLabel("Lens Price");
		
		JLabel lblNewLabel_8_8 = new JLabel("Total Amount");
		
		txtLensPrice = new JTextField();
		txtLensPrice.setEditable(false);
		txtLensPrice.setText("*****");
		txtLensPrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtLensPrice.setBackground(Color.CYAN);
		txtLensPrice.setColumns(10);
		
		txtTotalAmmount = new JTextField();
		txtTotalAmmount.setEditable(false);
		txtTotalAmmount.setText("*****");
		txtTotalAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtTotalAmmount.setBackground(Color.CYAN);
		txtTotalAmmount.setColumns(10);
		
		JLabel lblNewLabel_8_8_1 = new JLabel("Paid");
		
		JTextField txtPaidAmmount = new JTextField();
		txtPaidAmmount.setEditable(false);
		txtPaidAmmount.setText("*****");
		txtPaidAmmount.setHorizontalAlignment(SwingConstants.CENTER);
		txtPaidAmmount.setBackground(Color.PINK);
		txtPaidAmmount.setColumns(10);
		
		JLabel lblNewLabel_8_8_2 = new JLabel("Frame Price");
		
		txtFramePrice = new JTextField();
		txtFramePrice.setEditable(false);
		txtFramePrice.setText("*****");
		txtFramePrice.setHorizontalAlignment(SwingConstants.CENTER);
		txtFramePrice.setBackground(Color.PINK);
		txtFramePrice.setColumns(10);
		
		txtODCYL = new JTextField();
		txtODCYL.setEditable(false);
		txtODCYL.setText("*****");
		txtODCYL.setHorizontalAlignment(SwingConstants.CENTER);
		txtODCYL.setBackground(new Color(230, 230, 250));
		txtODCYL.setColumns(10);
		
		txtODAXIS = new JTextField();
		txtODAXIS.setEditable(false);
		txtODAXIS.setText("*****");
		txtODAXIS.setHorizontalAlignment(SwingConstants.CENTER);
		txtODAXIS.setBackground(new Color(255, 250, 205));
		txtODAXIS.setColumns(10);
		
		txtODVD = new JTextField();
		txtODVD.setEditable(false);
		txtODVD.setText("*****");
		txtODVD.setHorizontalAlignment(SwingConstants.CENTER);
		txtODVD.setBackground(new Color(211, 211, 211));
		txtODVD.setColumns(10);
		
		txtODADD = new JTextField();
		txtODADD.setEditable(false);
		txtODADD.setText("*****");
		txtODADD.setHorizontalAlignment(SwingConstants.CENTER);
		txtODADD.setBackground(new Color(204, 255, 204));
		txtODADD.setColumns(10);
		
		txtODVN = new JTextField();
		txtODVN.setEditable(false);
		txtODVN.setText("*****");
		txtODVN.setHorizontalAlignment(SwingConstants.CENTER);
		txtODVN.setBackground(new Color(0, 255, 255));
		txtODVN.setColumns(10);
		
		txtOSSPH = new JTextField();
		txtOSSPH.setEditable(false);
		txtOSSPH.setText("*****");
		txtOSSPH.setHorizontalAlignment(SwingConstants.CENTER);
		txtOSSPH.setBackground(new Color(255, 255, 240));
		txtOSSPH.setColumns(10);
		
		txtOSCYL = new JTextField();
		txtOSCYL.setEditable(false);
		txtOSCYL.setText("*****");
		txtOSCYL.setHorizontalAlignment(SwingConstants.CENTER);
		txtOSCYL.setBackground(new Color(230, 230, 250));
		txtOSCYL.setColumns(10);
		
		txtOSAXIS = new JTextField();
		txtOSAXIS.setEditable(false);
		txtOSAXIS.setText("*****");
		txtOSAXIS.setHorizontalAlignment(SwingConstants.CENTER);
		txtOSAXIS.setBackground(new Color(255, 250, 205));
		txtOSAXIS.setColumns(10);
		
		txtOSVD = new JTextField();
		txtOSVD.setEditable(false);
		txtOSVD.setText("*****");
		txtOSVD.setHorizontalAlignment(SwingConstants.CENTER);
		txtOSVD.setBackground(new Color(211, 211, 211));
		txtOSVD.setColumns(10);
		
		txtOSADD = new JTextField();
		txtOSADD.setEditable(false);
		txtOSADD.setText("*****");
		txtOSADD.setHorizontalAlignment(SwingConstants.CENTER);
		txtOSADD.setBackground(new Color(204, 255, 204));
		txtOSADD.setColumns(10);
		
		txtOSVN = new JTextField();
		txtOSVN.setEditable(false);
		txtOSVN.setText("*****");
		txtOSVN.setHorizontalAlignment(SwingConstants.CENTER);
		txtOSVN.setBackground(new Color(0, 255, 255));
		txtOSVN.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_7)
									.addComponent(lblNewLabel_7_1)
									.addComponent(lblNewLabel_7_2))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(txtOSSPH, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtOSCYL, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtOSAXIS, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtOSVD, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtOSADD, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtOSVN, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(lblNewLabel_7_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addComponent(lblNewLabel_7_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addComponent(lblNewLabel_7_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addComponent(lblNewLabel_7_6, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
										.addGap(22)
										.addComponent(lblNewLabel_7_7, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(lblNewLabel_7_8, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(txtODSPH, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtODCYL, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtODAXIS, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtODVD, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtODADD, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(txtODVN, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(87, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_8)
									.addGap(18)
									.addComponent(txtTotalAmmount, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_7)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtLensPrice, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
							.addGap(73)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_8_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtPaidAmmount, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_8_2)
									.addGap(18)
									.addComponent(txtFramePrice, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
							.addGap(64)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8_3)
						.addComponent(lblNewLabel_8_2)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_8_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLensFor)
						.addComponent(lblFrameType)
						.addComponent(lblLensSide)
						.addComponent(lblLensType))
					.addContainerGap(94, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8)
								.addComponent(lblLensType))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8_1)
								.addComponent(lblLensFor))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8_2)
								.addComponent(lblLensSide))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8_3)
								.addComponent(lblFrameType)))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7)
								.addComponent(lblNewLabel_7_3)
								.addComponent(lblNewLabel_7_4)
								.addComponent(lblNewLabel_7_5)
								.addComponent(lblNewLabel_7_7)
								.addComponent(lblNewLabel_7_8)
								.addComponent(lblNewLabel_7_6))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7_1)
								.addComponent(txtODSPH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtODCYL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtODAXIS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtODVD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtODADD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtODVN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7_2)
								.addComponent(txtOSSPH, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOSCYL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOSAXIS, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOSVD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOSADD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtOSVN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_8_8_2)
								.addComponent(txtFramePrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_8_7)
									.addComponent(txtLensPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtPaidAmmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8_8_1)
								.addComponent(lblNewLabel_8_8)
								.addComponent(txtTotalAmmount, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(45))
		);
		panel.setLayout(gl_panel);
		secondFromPane.setLayout(gl_secondFromPane);
		
		Map<String, JLabel> insertLable = new LinkedHashMap<>();
		Map<String, JTextField> insertData = new LinkedHashMap<String, JTextField>();
		insertData.put("sphOD" , rightSPH);
		insertData.put("cylOD" , rightCYL);
		insertData.put("axisOD" , rightAxis);
		insertData.put("vdOD" , rightVD);
		insertData.put("nearOD" , rightNear);
		insertData.put("vnOD" , rightVN);
		insertData.put("sphOS" , leftSPH);
		insertData.put("cylOS" , leftCYL);
		insertData.put("axisOS" , leftAxis);
		insertData.put("vdOS" , leftVD);
		insertData.put("nearOS" , leftNear);
		insertData.put("vnOS" , leftVN);
		insertData.put("LensType" , lensType);
		insertData.put("LensFor" , lensFor);
		insertData.put("LensSide" , lensSide);
		insertData.put("LensPrice" , lensPrice);
		insertData.put("FrameType" , frameType);
		insertData.put("FramePrice" , framePrice);
		insertData.put("PaidAmount" , paidAmount);
		insertData.put("ExtraCharges" , extraCharges);
		insertData.put("Remark" , remark);
		insertData.put("TotalAmount" , totalAmount);
		insertData.put("CustomerId" , prescriptionCustomerID);
		insertData.put("txtODSPH" , txtODSPH);
		insertData.put("txtODCYL" , txtODCYL);
		insertData.put("txtODAXIS" , txtODAXIS);
		insertData.put("txtODVD" , txtODVD);
		insertData.put("txtODADD" , txtODADD);
		insertData.put("txtODVN" , txtODVN);
		insertData.put("txtOSSPH" , txtOSSPH);
		insertData.put("txtOSCYL" , txtOSCYL);
		insertData.put("txtOSAXIS" , txtOSAXIS);
		insertData.put("txtOSVD" , txtOSVD);
		insertData.put("txtOSADD" , txtOSADD);
		insertData.put("txtOSVN" , txtOSVN);
		insertData.put("txtLensPrice" , txtLensPrice);
		insertData.put("txtFramePrice" , txtFramePrice);
		insertData.put("txtTotalAmmount" , txtTotalAmmount);
		insertData.put("txtPaidAmmount" , txtPaidAmmount);
		insertData.put("txtPrescriptionID" , txtPrescriptionID);
		
		insertLable.put( "lblLensType" , lblLensType );
		insertLable.put( "lblLensFor" , lblLensFor );
		insertLable.put( "lblLensSide" , lblLensSide );
		insertLable.put( "lblFrameType" , lblFrameType );
		
		prescripInsertBtn.addActionListener( new InsertPrescriptionHandler( insertData , pre_model ) );
		prescripClearBtn.addActionListener( new ClearPrescriptionHandler( insertData ) );
		prescripDeleteBtn.addActionListener( new deletePrescriptionHandler( insertData, pre_model ) );
		prescripUpdateBtn.addActionListener( new updatePrescriptionHandler( insertData , insertLable , pre_model ) );
		
		// action listener 17-05-2023
		
//		PreTableListner newListener = new PreTableListner( pre_model ,insertData , cusID );
		TableListener tableListener = new TableListener(table, customerName, customerAdd, customerContect,
		        customerAge, ExaminedBy, cusID, cusName, cusNum, genderMale, genderFemale, customerBdate , 
		        prescriptionCustomerID , pre_model ,insertData , insertLable );
		table.getSelectionModel().addListSelectionListener(tableListener);
		
		TablePrescriptionListner prescriptionTable = new TablePrescriptionListner( tablePrescription , pre_model ,insertData , insertLable );
		tablePrescription.getSelectionModel().addListSelectionListener(prescriptionTable);
		
		delete_btn.addActionListener( new DeleteData( cusID , model ) );
		update_btn.addActionListener( new UpdateHandler( cusID , save_data, customerBdate , buttonGroup , model ,scrollPane ) );
		
		scrollPane.getColumnHeader();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
    }
}
