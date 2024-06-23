package EyeCare;
import java.sql.SQLException;
import LoginManager.LoginPannel;
import TableConstrain.DataManager;
import UsersUtilitiesManager.UsersUtilities;


public class Launcher {
    public static void main(String[] args) throws SQLException {
//    	 LoginPannel loginPanel = new LoginPannel();
//         loginPanel.setVisible(true);
     	UsersUtilities uu = new UsersUtilities();
    	uu.setVisible(true);
         new DataManager();
    }
}