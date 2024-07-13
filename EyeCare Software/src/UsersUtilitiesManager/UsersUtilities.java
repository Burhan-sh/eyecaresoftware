package UsersUtilitiesManager;

import TableConstrain.GetUserUtilityData;
import TableConstrain.getUserInformation;
import LoginManager.EncriptAbsration;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class UsersUtilities extends JFrame{
	private static final long serialVersionUID = -4507973933625795364L;
	private JTextField old_pass;
	private JTextField new_pass;
	private JTextField confrim_pass;
	private JButton btnCancel;
	public UsersUtilities() {
		setTitle("Change Password");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setAlwaysOnTop(true);
		getContentPane().setLayout(null);
		setSize(500, 300);
        setLocationRelativeTo(null);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		
		GetUserUtilityData GUD = new GetUserUtilityData();
		List<ContainerObject> objList = GUD.getUserData();
		EncriptAbsration en = new EncriptAbsration();
	    for (ContainerObject obj : objList) {
	    	comboBox.addItem(obj.username);
	    }
		
		comboBox.setBounds(219, 41, 184, 22);
		getContentPane().add(comboBox);
		
		old_pass = new JTextField();
		old_pass.setBounds(219, 76, 184, 20);
		getContentPane().add(old_pass);
		old_pass.setColumns(10);
		
		new_pass = new JTextField();
		new_pass.setBounds(219, 107, 184, 20);
		new_pass.setColumns(10);
		getContentPane().add(new_pass);
		
		confrim_pass = new JTextField();
		confrim_pass.setBounds(219, 138, 184, 20);
		confrim_pass.setColumns(10);
		getContentPane().add(confrim_pass);
		
		JButton btnNewButton = new JButton("Update Password");
		btnNewButton.setBounds(73, 183, 147, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!old_pass.getText().isEmpty() && !new_pass.getText().isEmpty() && !confrim_pass.getText().isEmpty()) {
					String selectedUser = (String) comboBox.getSelectedItem();
					String existingPass = null;
					String user_id = null;
					for (ContainerObject obj : objList) {
				    	if(selectedUser.equals(obj.username)) {
				    		existingPass = en.setDecryption(obj.password);
				    		user_id = obj.user_id;
				    	}
				    }					
					PasswordValidation pw = new PasswordValidation();
					boolean validation = pw.matchPassword(new_pass.getText(),confrim_pass.getText());
					if(validation) {
						boolean checkOldPass = pw.matchPassword(old_pass.getText(),existingPass);
						if(checkOldPass) {
							getUserInformation gui = new getUserInformation();
							Boolean sucess = gui.updatePassword(user_id, en.setEncryption(new_pass.getText()));
							if(sucess) {
								UsersUtilities.this.dispose();
								JOptionPane.showMessageDialog(UsersUtilities.this,"Password Updated","Password Updated !!!",JOptionPane.INFORMATION_MESSAGE);
							}else{
								JOptionPane.showMessageDialog(UsersUtilities.this,"Password Not Updated","Error",JOptionPane.ERROR_MESSAGE);
							}
						}else {
							JOptionPane.showMessageDialog(UsersUtilities.this,"Please Provide correct password","Error",JOptionPane.ERROR_MESSAGE);
						}
					}else {
				         JOptionPane.showMessageDialog(UsersUtilities.this,"New Password and confirm password should be match!!!","Error",JOptionPane.ERROR_MESSAGE);
				    }
				}else {
					JOptionPane.showMessageDialog(UsersUtilities.this,"Please Enter password","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		getContentPane().add(btnNewButton);
		
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsersUtilities.this.dispose();
			}
		});
		btnCancel.setBounds(230, 183, 148, 23);
		getContentPane().add(btnCancel);
		
		JLabel lblNewLabel = new JLabel("Select User Name");
		lblNewLabel.setBounds(29, 48, 132, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblTypeOldPassword = new JLabel("Type old password");
		lblTypeOldPassword.setBounds(29, 82, 132, 14);
		getContentPane().add(lblTypeOldPassword);
		
		JLabel lblTypeNewPassword = new JLabel("Type new Password");
		lblTypeNewPassword.setBounds(29, 113, 148, 14);
		getContentPane().add(lblTypeNewPassword);
		
		JLabel lblTypeConfirmPassword = new JLabel("Type confirm password");
		lblTypeConfirmPassword.setBounds(29, 144, 161, 14);
		getContentPane().add(lblTypeConfirmPassword);
	}
}
