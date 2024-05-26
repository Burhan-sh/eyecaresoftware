package EyeCare;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ExtraFunctions {

	private JTable table;

	
	public ExtraFunctions() {
		// TODO Auto-generated constructor stub

	}
	
	public ExtraFunctions( JTable table , DefaultTableModel model  ) {
		this.table = table;
		hideColumn("ID");
	}
	
	public JTable getTableData() {
		return table;
	}

	private void hideColumn(String columnName) {
        TableColumnModel columnModel = table.getColumnModel();
        int columnIndex = table.getColumnModel().getColumnIndex(columnName);
        TableColumn column = columnModel.getColumn(columnIndex);
        column.setMinWidth(0);
        column.setMaxWidth(0);
        column.setWidth(0);
        column.setPreferredWidth(0);
        columnModel.getColumn(columnIndex).setResizable(false);
    }
	
	public void searchByFunc(JComboBox<String> comboBox) {
		String [] values = { "Name" , "Address" , "ContectNo" , "ExaminedBy" , "BirthDate" };
		comboBox.addItem("Search By");
		for (int i = 0; i < values.length; i++) {
		    comboBox.addItem(values[i]);
		}
	}
	
	public String updateDateLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = dateFormat.format(new Date());
        return formattedDate;
    }
	
    public static JLabel resizeImage(int desiredWidth, int desiredHeight) {
        JPanel norContainer = new JPanel();
        JLabel imgLabel = new JLabel("");

        ImageIcon originalIcon = new ImageIcon(ExtraFunctions.class.getResource("/eyecareimg.jpg"));
        Image originalImage = originalIcon.getImage();

        BufferedImage resizedImage = new BufferedImage(desiredWidth, desiredHeight, BufferedImage.TYPE_INT_ARGB);

        // Scale the original image to the desired dimensions using the Graphics class
        java.awt.Graphics2D g2d = resizedImage.createGraphics();
        g2d.drawImage(originalImage, 0, 0, desiredWidth, desiredHeight, null);
        g2d.dispose();

        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        // Set the resized image icon to the label
        imgLabel.setIcon(resizedIcon);

        norContainer.add(imgLabel);
        return imgLabel;
    }
}
