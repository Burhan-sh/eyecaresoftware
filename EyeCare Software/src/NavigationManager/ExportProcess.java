package NavigationManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.model.enums.CompressionLevel;
import net.lingala.zip4j.model.enums.EncryptionMethod;

public class ExportProcess {
	private static final String DB_FILE_NAME = "EyeCare.db";
		
    private void createBackupFile(String dbFileName, String backupFilePath) throws IOException {
        // Create a temporary backup file
        File tempBackupFile = File.createTempFile("eyecare_backup", ".bkt");

        try (FileOutputStream fos = new FileOutputStream(tempBackupFile);
             FileInputStream fis = new FileInputStream(dbFileName)) {

            // Copy the database file to the backup file
            byte[] buffer = new byte[65536];  // Use a larger buffer size
            int length;
            while ((length = fis.read(buffer)) > 0) {
                fos.write(buffer, 0, length);
            }
        }

        // Create a zip file with the backup file
      
        // Set zip file parameters
        ZipParameters zipParameters = new ZipParameters();
        zipParameters.setEncryptFiles(true);
        zipParameters.setCompressionLevel(CompressionLevel.NORMAL);
        zipParameters.setEncryptionMethod(EncryptionMethod.AES);

        try {
        	@SuppressWarnings("resource")
			ZipFile zipFile = new ZipFile(backupFilePath , "01-06-1991".toCharArray());
            zipFile.addFile(tempBackupFile, zipParameters);

//            JOptionPane.showMessageDialog(null, "Backup File Exported to: " + backupFilePath);
        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Backup File Error exporting : " + ex.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
        }

        // Delete the temporary backup file
        tempBackupFile.delete();
    }
    
    
    public void deleteEyeCareDBFile() {
    	
    	String filePath = "EyeCare.db"; // Path to the EyeCare.db file
    	   // Establish the database connection
        Connection connection;
		try {
			connection = DriverManager.getConnection("jdbc:sqlite:" + filePath.toString());
	        // Close the database connection
	        connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Path fileToDelete = Paths.get(filePath);
        
        try {
            Thread.sleep(1000); // Adjust the delay duration if needed
            
            Files.delete(fileToDelete);
            JOptionPane.showMessageDialog(null, "EyeCare.db file deleted successfully!");
        } catch (IOException | InterruptedException e) {
            JOptionPane.showMessageDialog(null, "Failed to delete EyeCare.db file.");
            e.printStackTrace();
        }
    }
    
    public void exportBackup() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select Export Location");
        fileChooser.setSelectedFile(new File(System.getProperty("user.home") + File.separator + "Desktop" + File.separator + "EyeCareBackup.bkt"));

        // Set file filter to only allow .bkt files
        FileNameExtensionFilter filter = new FileNameExtensionFilter("EyeCare Backup File", "bkt");
        fileChooser.setFileFilter(filter);

        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();

            // Append .bkt extension if not present
            if (!filePath.endsWith(".bkt")) {
                filePath += ".bkt";
            }

            try {
                // Create the backup file
                createBackupFile(DB_FILE_NAME, filePath);

                JOptionPane.showMessageDialog(null, "Backup File Exported to: " + filePath);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Backup File Error exporting : " + ex.getMessage(), "Export Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

}
