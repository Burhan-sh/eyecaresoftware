package EyeCare;

import java.awt.EventQueue;
import javax.swing.JFrame;
import TableConstrain.*;

public class Launcher {
    public static void main(String[] args) {
        SingleInstanceChecker instanceChecker = new SingleInstanceChecker();
//        if (instanceChecker.isAppAlreadyRunning()) {
//            instanceChecker.showAppAlreadyRunningError();
//            System.exit(0);
//        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	new DataManager();
                	
                    main frame = new main();
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