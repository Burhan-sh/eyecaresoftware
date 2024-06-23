package LoginManager;

import java.awt.Image;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import TableConstrain.getUserInformation;

public class LoginAuthintication {
    private HashMap<String, String> userTable;

    public LoginAuthintication() {
    	getUserInformation dbUtil = new getUserInformation();
    	this.userTable = dbUtil.getUserInfo();
    }
    
    public boolean verifications(String username, String password) {
        if(this.hasSQLInjectionRisk(username) && this.hasSQLInjectionRisk(password) ) {
        	if(this.authenticate(username,password)) {
        		getUserInformation ui = new getUserInformation();
        		String user_id = ui.getUserId(username);
        		LoginSessions.setUserId(user_id);
        		return true;
        	}else {
        		JOptionPane.showMessageDialog(null, "Username and Password are not Matched !!!");
        		return false;
        	}
        }else {
        	String iconFileName = "vulnerability.png";
        	ImageIcon icon = new ImageIcon(getClass().getResource("/" + iconFileName));
        	Image resizedImage = icon.getImage().getScaledInstance(55, 55, Image.SCALE_SMOOTH);
        	ImageIcon warningIcon = new ImageIcon(resizedImage);
        	
        	JOptionPane.showMessageDialog(null, "Security vulnerability Warning!!","Warning",JOptionPane.WARNING_MESSAGE, warningIcon);
        	return false;
        }
    }

    public boolean authenticate(String username, String password) {
        String storedPassword = userTable.get(username);
        return storedPassword != null && storedPassword.equals(password);
    }
    
    private boolean hasSQLInjectionRisk(String input) {
        String[] sqlInjectionRiskWords = {"SELECT", "INSERT", "UPDATE", "DELETE", "DROP", "--", ";", "/*", "*/"};
        for (String riskWord : sqlInjectionRiskWords) {
            if (input.toUpperCase().contains(riskWord)) {
                return false;
            }
        }
        return true;
    }
}