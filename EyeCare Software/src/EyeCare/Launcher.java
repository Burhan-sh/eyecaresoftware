package EyeCare;
import java.sql.SQLException;

import LoginManager.LoginPannel;
import TableConstrain.DataManager;


public class Launcher {
    public static void main(String[] args) throws SQLException {
//    	new LoginChunk();
    	 LoginPannel loginPanel = new LoginPannel();
         loginPanel.setVisible(true);
         new DataManager();
    }
}