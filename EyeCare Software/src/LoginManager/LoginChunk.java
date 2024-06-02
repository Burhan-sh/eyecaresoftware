package LoginManager;

import java.awt.EventQueue;
import javax.swing.JFrame;
import EyeCare.SingleInstanceChecker;
import EyeCare.main;
import TableConstrain.DataManager;

public class LoginChunk {
	public static main frame;
	public LoginChunk() {
		SingleInstanceChecker instanceChecker = new SingleInstanceChecker();
		if (instanceChecker.isAppAlreadyRunning()) {
			instanceChecker.showAppAlreadyRunningError();
			System.exit(0);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new DataManager();
					
					frame = new main();
					frame.setVisible(true);
					frame.setResizable(false);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
					Runtime.getRuntime().addShutdownHook(new Thread() {
						public void run() {
							instanceChecker.removeLockFile();
						}
					});
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
