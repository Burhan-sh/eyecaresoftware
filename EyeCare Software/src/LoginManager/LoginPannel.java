package LoginManager;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.Color;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;

@SuppressWarnings("serial")
public class LoginPannel extends JFrame {
    public JTextField textField;
    public JPasswordField textField_1;

    public LoginPannel() {
        setTitle("Login Screen");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(0, 255, 255));
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(24)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(31, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
            groupLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                    .addGap(26)
                    .addComponent(panel, GroupLayout.PREFERRED_SIZE, 207, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(27, Short.MAX_VALUE))
        );
        panel.setLayout(null);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 105, 206);
        panel.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel posterKeys = new JLabel("");
        posterKeys.setBounds(10, 38, 85, 129);
        ImageIcon posterIcon = new ImageIcon(getClass().getResource("/passwordkeymain.png"));
        Image posterImage = posterIcon.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon posterReseziedIcon = new ImageIcon(posterImage);
        posterKeys.setIcon(posterReseziedIcon);
        panel_1.add(posterKeys);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(102, 0, 326, 206);
        panel.add(panel_2);
        panel_2.setLayout(null);
        
        textField = new JTextField();
        textField.setBounds(92, 61, 193, 27);
        panel_2.add(textField);
        textField.setColumns(10);
        
        textField_1 = new JPasswordField(20);;
        textField_1.setColumns(10);
        textField_1.setBounds(92, 99, 193, 27);
        panel_2.add(textField_1);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginButton.setForeground(new Color(255, 255, 255));
        loginButton.setBackground(new Color(0, 0, 255));
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Handle login action
                String username = textField.getText();
                String password = new String(textField_1.getPassword());
                if (username == null || username.trim().isEmpty() || password == null || password.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Username or password cannot be blank.");
                }else {
                	LoginAuthintication auth = new LoginAuthintication();
                	Boolean valid = auth.verifications(username,password);
                	if(valid) {
                		dispose();
                		new LoginChunk();
                	}
                }
            }
        });
        loginButton.setBounds(92, 137, 89, 23);
        panel_2.add(loginButton);
        
        JButton loginRevertButton = new JButton("Cancel");
        loginRevertButton.setFont(new Font("Arial", Font.BOLD, 12));
        loginRevertButton.setForeground(new Color(255, 255, 255));
        loginRevertButton.setBackground(Color.BLUE);
        loginRevertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        loginRevertButton.setBounds(191, 137, 89, 23);
        panel_2.add(loginRevertButton);
        
        JLabel userNameIco = new JLabel("");
        userNameIco.setBounds(28, 61, 45, 30);
        panel_2.add(userNameIco);
        // Load and resize the icon
        ImageIcon icon = new ImageIcon(getClass().getResource("/usernameico.png"));
        Image resizedImage = icon.getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Set the resized icon to the JLabel
        userNameIco.setIcon(resizedIcon);
        
        JLabel passwordLabel = new JLabel("");
        passwordLabel.setBounds(28, 99, 45, 27);
        ImageIcon passIcon = new ImageIcon(getClass().getResource("/userpassword.png"));
        Image passResizedImage = passIcon.getImage().getScaledInstance(45, 35, Image.SCALE_SMOOTH);
        ImageIcon passresizedIcon = new ImageIcon(passResizedImage);
        passwordLabel.setIcon(passresizedIcon);
        panel_2.add(passwordLabel);
        
        getContentPane().setLayout(groupLayout);
    }
}
