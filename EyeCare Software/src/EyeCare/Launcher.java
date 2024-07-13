package EyeCare;

import SecurityPrivacy.HideDBFolder;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import LoginManager.LoginPannel;
import TableConstrain.DataManager;
import TableConstrain.GetCustmerData;

public class Launcher {
    public static void main(String[] args) throws SQLException {
    	 LoginPannel loginPanel = new LoginPannel();
    	 GetCustmerData counter = new GetCustmerData();
    	 int count = counter.getCustomerCount();
    	 if(count > 99) {
    		 JOptionPane.showMessageDialog(null, "You have reached Demo Limit Please contact developer for more details");
    		 return;
    	 }
    	 if (!loginPanel.isVisible() ) {
	         loginPanel.setVisible(true);
	         new DataManager();
	         
	         String rootPath = System.getProperty("user.dir");
	         String folderPath = rootPath + "/sysconfig";
	         
	         try {
	             HideDBFolder.hideFolder(folderPath);
	         } catch (IOException e) {
	             e.printStackTrace();
	         }
    	 }else {
    		 JOptionPane.showMessageDialog(null, "App Is Already Open Please Check!!");
    	 }
    }
}