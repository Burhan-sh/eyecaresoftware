import java.awt.EventQueue;
import TableConstrain.DataManager;
public class Launcher {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//main frame = new main();
					//frame.setVisible(true);
					var dataManager = new DataManager();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
