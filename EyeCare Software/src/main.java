import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Insets;
import javax.swing.JMenuItem;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import java.awt.ComponentOrientation;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.SpringLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import com.toedter.calendar.JDateChooser;
import java.awt.CardLayout;
import javax.swing.Box;
import java.awt.Panel;
import java.awt.Label;
import java.awt.Choice;
import java.awt.TextField;
import java.awt.SystemColor;

public class main extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private JTextField textField_4;
	private JTextField txtCvcbc;
	private JTextField textField_5;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_9;
	private JTextField textField_21;
	private JTextField textField_23;
	private JPanel panel_5;
	private JTextField textField_22;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;
	private JTextField textField_27;
	private JTextField textField_28;
	private JTextField textField_29;
	private JTextField textField_30;
	private JTextField textField_31;
	private JTextField textField_32;
	private JTextField textField_33;
	private JTextField textField_34;
	private JTextField textField_35;
	private JTextField textField_36;
	private JTextField textField_37;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(75, 75, 1201, 587);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Home");
		mnNewMenu.setMargin(new Insets(3, 3, 3, 3));
		mnNewMenu.setActionCommand("Home");
		menuBar.add(mnNewMenu);
		
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
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
						.addComponent(secondFromPane, GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(tabbedPane, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(secondFromPane, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(108, Short.MAX_VALUE))
		);
		panel_3.setLayout(new MigLayout("", "[][][][][][][][]", "[][]"));
		
		JLabel lblNewLabel_10 = new JLabel("Search Patient");
		panel_3.add(lblNewLabel_10, "cell 0 0,alignx trailing");
		
		textField_21 = new JTextField();
		panel_3.add(textField_21, "cell 1 0");
		textField_21.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		panel_3.add(comboBox, "cell 2 0");
		comboBox.addItem("Select By Name");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("(+)Add New Information", null, panel_1, null);
		panel_1.setLayout(new MigLayout("", "[][]25[]25[][][][]", "[]15[]15[]15[]15[]15[]15[]15[]20[]"));
		
		JLabel lblNewLabel = new JLabel("Name");
		panel_1.add(lblNewLabel, "cell 0 1");
		
		textField = new JTextField();
		panel_1.add(textField, "cell 1 1");
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Examined By");
		panel_1.add(lblNewLabel_3, "cell 3 1");
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		panel_1.add(textField_9, "cell 4 1");
		
		JLabel lblNewLabel_1 = new JLabel("Address");
		panel_1.add(lblNewLabel_1, "cell 0 2");
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		panel_1.add(textField_1, "cell 1 2");
		
		JLabel lblNewLabel_1_1 = new JLabel("Bithdate");
		panel_1.add(lblNewLabel_1_1, "cell 3 2");
		
		JDateChooser dateChooser = new JDateChooser();
		panel_1.add(dateChooser, "cell 4 2,grow");
		
		JLabel lblNewLabel_2 = new JLabel("Contect No");
		panel_1.add(lblNewLabel_2, "cell 0 3");
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		panel_1.add(textField_2, "cell 1 3");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Gender");
		panel_1.add(lblNewLabel_2_1_1, "cell 3 3");
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		panel_1.add(rdbtnNewRadioButton, "flowx,cell 4 3");
		
		JLabel lblNewLabel_2_1 = new JLabel("Age");
		panel_1.add(lblNewLabel_2_1, "cell 0 4");
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_1.add(textField_3, "cell 1 4");
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setPreferredSize(new Dimension(120, 30));
		panel_1.add(btnNewButton, "cell 0 6 7 1,alignx center");
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setPreferredSize(new Dimension(120, 30));
		panel_1.add(btnNewButton_1, "cell 0 6 7 1,alignx center");
		
		JButton btnNewButton_2 = new JButton("Update");
		btnNewButton_2.setPreferredSize(new Dimension(120, 30));
		panel_1.add(btnNewButton_2, "cell 0 6 7 1,alignx center");
		
		JButton btnNewButton_2_1 = new JButton("Delete");
		btnNewButton_2_1.setPreferredSize(new Dimension(120, 30));
		panel_1.add(btnNewButton_2_1, "cell 0 6 7 1,alignx center");
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
		panel_1.add(rdbtnNewRadioButton_1, "cell 4 3");
		
		
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Add New Prescription", null, panel_2, null);
		
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
		
		Object[][] pre_data= {{"16","25-05-2022","8"},
						  {"17","25-05-2022","8"},
						  {"18","25-05-2022","8"}};
		String[] pre_columName = {"Precription ID" , "Order Date" , "Id"};
		DefaultTableModel pre_model = new DefaultTableModel(pre_data,pre_columName);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_6.add(scrollPane_1);
		
		table_1 = new JTable(pre_model);
		scrollPane_1.setViewportView(table_1);
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
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
		
		textField_22 = new JTextField();
		panel_7.add(textField_22, "cell 1 1");
		textField_22.setColumns(10);
		
		textField_24 = new JTextField();
		panel_7.add(textField_24, "cell 2 1");
		textField_24.setColumns(10);
		
		textField_25 = new JTextField();
		panel_7.add(textField_25, "cell 3 1");
		textField_25.setColumns(10);
		
		textField_26 = new JTextField();
		panel_7.add(textField_26, "cell 4 1");
		textField_26.setColumns(10);
		
		textField_27 = new JTextField();
		panel_7.add(textField_27, "cell 5 1");
		textField_27.setColumns(10);
		
		textField_28 = new JTextField();
		panel_7.add(textField_28, "cell 6 1");
		textField_28.setColumns(10);
		
		Label label_8 = new Label("OS(Left)");
		panel_7.add(label_8, "cell 0 2");
		
		textField_29 = new JTextField();
		textField_29.setColumns(10);
		panel_7.add(textField_29, "cell 1 2");
		
		textField_30 = new JTextField();
		textField_30.setColumns(10);
		panel_7.add(textField_30, "cell 2 2");
		
		textField_31 = new JTextField();
		textField_31.setColumns(10);
		panel_7.add(textField_31, "cell 3 2");
		
		textField_32 = new JTextField();
		textField_32.setColumns(10);
		panel_7.add(textField_32, "cell 4 2");
		
		textField_33 = new JTextField();
		textField_33.setColumns(10);
		panel_7.add(textField_33, "cell 5 2");
		
		textField_34 = new JTextField();
		textField_34.setColumns(10);
		panel_7.add(textField_34, "wrap");
		
		Panel panel_8 = new Panel();
		panel_8.setBounds(10, 99, 397, 142);
		panel_5.add(panel_8);
		panel_8.setLayout(new MigLayout("", "[][grow][][][][][grow]", "[][][][][]"));
		
		Label label_9 = new Label("Lens Type");
		panel_8.add(label_9, "cell 0 0");
		
		textField_35 = new JTextField();
		panel_8.add(textField_35, "cell 1 0");
		textField_35.setColumns(10);
		
		Label label_10 = new Label("Lens For");
		panel_8.add(label_10, "cell 5 0");
		
		textField_36 = new JTextField();
		panel_8.add(textField_36, "cell 6 0,growx");
		textField_36.setColumns(10);
		
		Label label_9_1 = new Label("Lens Side");
		panel_8.add(label_9_1, "cell 0 1");
		
		textField_37 = new JTextField();
		textField_37.setColumns(10);
		panel_8.add(textField_37, "cell 1 1,growx");
		
		Label label_10_1 = new Label("Lens Price");
		panel_8.add(label_10_1, "cell 5 1");
		
		textField_38 = new JTextField();
		textField_38.setColumns(10);
		panel_8.add(textField_38, "cell 6 1,growx");
		
		Label label_9_1_1 = new Label("Frame Type");
		panel_8.add(label_9_1_1, "cell 0 2");
		
		textField_39 = new JTextField();
		textField_39.setColumns(10);
		panel_8.add(textField_39, "cell 1 2,growx");
		
		Label label_10_1_1 = new Label("Frame Price");
		panel_8.add(label_10_1_1, "cell 5 2");
		
		textField_40 = new JTextField();
		textField_40.setColumns(10);
		panel_8.add(textField_40, "cell 6 2,growx");
		
		Label label_11 = new Label("Paid Amount");
		panel_8.add(label_11, "cell 0 3");
		
		textField_41 = new JTextField();
		panel_8.add(textField_41, "cell 1 3,growx");
		textField_41.setColumns(10);
		
		Label label_12 = new Label("Extra Charges");
		panel_8.add(label_12, "cell 5 3");
		
		textField_42 = new JTextField();
		panel_8.add(textField_42, "cell 6 3,growx");
		textField_42.setColumns(10);
		
		Label label_13 = new Label("Remark");
		panel_8.add(label_13, "cell 0 4");
		
		textField_43 = new JTextField();
		textField_43.setText("");
		panel_8.add(textField_43, "cell 1 4,growx");
		textField_43.setColumns(10);
		
		Label label_14 = new Label("Total amount");
		panel_8.add(label_14, "cell 5 4");
		
		textField_44 = new JTextField();
		panel_8.add(textField_44, "cell 6 4,growx");
		textField_44.setColumns(10);
		
		Panel panel_9 = new Panel();
		FlowLayout flowLayout = (FlowLayout) panel_9.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(20);
		panel_9.setBounds(10, 247, 397, 46);
		panel_5.add(panel_9);
		
		JButton btnNewButton_3 = new JButton("Insert");
		panel_9.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		panel_9.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Clear");
		panel_9.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Delete");
		panel_9.add(btnNewButton_6);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 15));
		
		JLabel lblNewLabel_11 = new JLabel("Customer ID");
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_13 = new JLabel("1255");
		lblNewLabel_13.setForeground(Color.DARK_GRAY);
		panel_4.add(lblNewLabel_13);
		
		Component horizontalStrut = Box.createHorizontalStrut(50);
		panel_4.add(horizontalStrut);
		
		JLabel lblNewLabel_12 = new JLabel("Prescription ID");
		panel_4.add(lblNewLabel_12);
		
		textField_23 = new JTextField();
		panel_4.add(textField_23);
		textField_23.setColumns(10);
		panel_2.setLayout(gl_panel_2);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Priscription", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_4 = new JLabel("Customer ID :");
		
		JLabel lblNewLabel_5 = new JLabel("103");
		
		JLabel lblNewLabel_4_1 = new JLabel("Name : ");
		
		JLabel lblNewLabel_5_1 = new JLabel("John Doe");
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Contect No :");
		
		JLabel lblNewLabel_5_1_1 = new JLabel("9687588986");
		
		JLabel lblNewLabel_6 = new JLabel("Prescription ID");
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		GroupLayout gl_secondFromPane = new GroupLayout(secondFromPane);
		gl_secondFromPane.setHorizontalGroup(
			gl_secondFromPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_secondFromPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_secondFromPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 702, Short.MAX_VALUE)
						.addGroup(gl_secondFromPane.createSequentialGroup()
							.addComponent(lblNewLabel_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5)
							.addGap(43)
							.addComponent(lblNewLabel_4_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5_1)
							.addGap(30)
							.addComponent(lblNewLabel_4_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_5_1_1, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_6)
							.addGap(5)
							.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE)
							.addGap(10))))
		);
		gl_secondFromPane.setVerticalGroup(
			gl_secondFromPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_secondFromPane.createSequentialGroup()
					.addGroup(gl_secondFromPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_4_1)
						.addComponent(lblNewLabel_5_1)
						.addComponent(lblNewLabel_4_1_1)
						.addComponent(lblNewLabel_5_1_1)
						.addComponent(lblNewLabel_6)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 194, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(26, Short.MAX_VALUE))
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
		
		txtCvcbc = new JTextField();
		txtCvcbc.setText("*****");
		txtCvcbc.setEnabled(false);
		txtCvcbc.setHorizontalAlignment(SwingConstants.CENTER);
		txtCvcbc.setBackground(new Color(255, 255, 240));
		txtCvcbc.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Lens Type");
		lblNewLabel_8.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_8_1 = new JLabel("Lens For");
		lblNewLabel_8_1.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_8_2 = new JLabel("Lens Side");
		lblNewLabel_8_2.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_8_3 = new JLabel("Frame Type");
		lblNewLabel_8_3.setFont(new Font("Sitka Small", Font.BOLD, 11));
		
		JLabel lblNewLabel_9 = new JLabel("----");
		
		JLabel lblNewLabel_8_4 = new JLabel("----");
		
		JLabel lblNewLabel_8_5 = new JLabel("----");
		
		JLabel lblNewLabel_8_6 = new JLabel("----");
		
		JLabel lblNewLabel_8_7 = new JLabel("Lens Price");
		
		JLabel lblNewLabel_8_8 = new JLabel("Total Amount");
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setText("*****");
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setBackground(Color.CYAN);
		textField_5.setColumns(10);
		
		textField_18 = new JTextField();
		textField_18.setEnabled(false);
		textField_18.setText("*****");
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setBackground(Color.CYAN);
		textField_18.setColumns(10);
		
		JLabel lblNewLabel_8_8_1 = new JLabel("Paid");
		
		textField_19 = new JTextField();
		textField_19.setEnabled(false);
		textField_19.setText("*****");
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setBackground(Color.PINK);
		textField_19.setColumns(10);
		
		JLabel lblNewLabel_8_8_2 = new JLabel("Frame Price");
		
		textField_20 = new JTextField();
		textField_20.setEnabled(false);
		textField_20.setText("*****");
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setBackground(Color.PINK);
		textField_20.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setText("*****");
		textField_6.setEnabled(false);
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setBackground(new Color(230, 230, 250));
		textField_6.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setText("*****");
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setBackground(new Color(255, 250, 205));
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setText("*****");
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setBackground(new Color(211, 211, 211));
		textField_8.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setText("*****");
		textField_10.setHorizontalAlignment(SwingConstants.CENTER);
		textField_10.setBackground(new Color(204, 255, 204));
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setText("*****");
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setBackground(new Color(0, 255, 255));
		textField_11.setColumns(10);
		
		textField_12 = new JTextField();
		textField_12.setEnabled(false);
		textField_12.setText("*****");
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setBackground(new Color(255, 255, 240));
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setEnabled(false);
		textField_13.setText("*****");
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setBackground(new Color(230, 230, 250));
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setEnabled(false);
		textField_14.setText("*****");
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setBackground(new Color(255, 250, 205));
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setEnabled(false);
		textField_15.setText("*****");
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setBackground(new Color(211, 211, 211));
		textField_15.setColumns(10);
		
		textField_16 = new JTextField();
		textField_16.setEnabled(false);
		textField_16.setText("*****");
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setBackground(new Color(204, 255, 204));
		textField_16.setColumns(10);
		
		textField_17 = new JTextField();
		textField_17.setEnabled(false);
		textField_17.setText("*****");
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setBackground(new Color(0, 255, 255));
		textField_17.setColumns(10);
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
										.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
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
										.addComponent(txtCvcbc, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))))
							.addGap(46))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(87, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_8)
									.addGap(18)
									.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_7)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
							.addGap(73)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_8_1)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblNewLabel_8_8_2)
									.addGap(18)
									.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)))
							.addGap(64)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8_3)
						.addComponent(lblNewLabel_8_2)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel_8_1))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8_4)
						.addComponent(lblNewLabel_8_6)
						.addComponent(lblNewLabel_8_5)
						.addComponent(lblNewLabel_9))
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
								.addComponent(lblNewLabel_9))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8_1)
								.addComponent(lblNewLabel_8_4))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8_2)
								.addComponent(lblNewLabel_8_5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_8_3)
								.addComponent(lblNewLabel_8_6)))
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
								.addComponent(txtCvcbc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_10, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_11, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(11)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_7_2)
								.addComponent(textField_12, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_13, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_14, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_15, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_16, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_17, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_8_8_2)
								.addComponent(textField_20, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblNewLabel_8_7)
									.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(textField_19, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_8_8_1)
								.addComponent(lblNewLabel_8_8)
								.addComponent(textField_18, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(45))
		);
		panel.setLayout(gl_panel);
		secondFromPane.setLayout(gl_secondFromPane);
		Object[][] data= {{101 , "YOYO" , "Yoiunsadby" , "401 hasdhwiadsas sad" , "25-03-2022" , "9033014526" , "Male" , 20},
				{102 , "Bilodna" , "Dr. isadjw" , "42 sadwiadsas sad" , "25-04-2022" , "9033514526" , "Female" , 30},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{102 , "Bilodna" , "Dr. isadjw" , "42 sadwiadsas sad" , "25-04-2022" , "9033514526" , "Female" , 30},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22},
				{103 , "lcsaeds" , "Dr. Hdnade" , "1 dhwiadsas sd" , "25-03-2022" , "9033014526" , "Male" , 22}};
		String[] columName = {"ID" , "Name" , "Examined By" , "Address" , "Birth Date" , "Contect No" , "Gender" , "Age"};
		DefaultTableModel model = new DefaultTableModel(data,columName);
		
		table = new JTable(model);
		table.getTableHeader();
		table.setCellSelectionEnabled(true);
		table.setColumnSelectionAllowed(true);
//		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.getColumnHeader();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
