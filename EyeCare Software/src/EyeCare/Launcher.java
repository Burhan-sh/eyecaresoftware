package EyeCare;
import LoginManager.LoginChunk;
import LoginManager.LoginPannel;
import LoginManager.LoginSessions;

public class Launcher {
    public static void main(String[] args) {
    	 LoginPannel loginPanel = new LoginPannel();
         loginPanel.setVisible(true);
//        if(LoginSessions.getUserId() != null) {
//        	new LoginChunk();
//        }else {
////        	new LoginPannel();
//        	System.out.println("hello");
//        }
    }
}