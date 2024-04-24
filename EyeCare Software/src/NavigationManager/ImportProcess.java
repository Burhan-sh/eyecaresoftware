package NavigationManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import net.lingala.zip4j.ZipFile;

public class ImportProcess {
	private File getPrivateImport() {
	      JFileChooser fileChooser = new JFileChooser();
	      File seletedFile = null;
	        int option = fileChooser.showOpenDialog(fileChooser);
	        if (option == JFileChooser.APPROVE_OPTION) {
	            File selectedFile = fileChooser.getSelectedFile();
	            try {
	                // Create 'listImports' folder
	                File listImportsFolder = new File("listImports");
	                if (!listImportsFolder.exists()) {
	                    if (!listImportsFolder.mkdir()) {
	                        throw new RuntimeException("Failed to create 'listImports' folder.");
	                    }
	                }

	                // Copy the file to 'listImports' folder
	                String newFilePath = listImportsFolder.getAbsolutePath() + File.separator + selectedFile.getName();
	                File newFile = new File(newFilePath);
	                Files.copy(selectedFile.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

	                // Change the extension to ".zip"
	                String zipFilePath = newFilePath + ".zip";
	                File zipFile = new File(zipFilePath);
	                newFile.renameTo(zipFile);

	                // Extract contents of the ZIP file
	                String password = "01-06-1991";
	                @SuppressWarnings("resource")
					ZipFile zip = new ZipFile(zipFile);
	                zip.setPassword(password.toCharArray());
	                zip.extractAll(listImportsFolder.getAbsolutePath());
	                
	                // Assuming the zip contains a single file, you can get the extracted file path as follows:
	                String extractedFileName = zip.getFileHeaders().get(0).getFileName();
	                String extractedFilePath = "listImports" + File.separator + extractedFileName;
	                seletedFile = new File(extractedFilePath);
	                
	                // Delete the ZIP file
	                if (!zipFile.delete()) {
	                    throw new RuntimeException("Failed to delete the ZIP file.");
	                }

	            } catch (ZipException e1) {
	                JOptionPane.showMessageDialog(fileChooser, "Failed to extract ZIP file. Invalid password or corrupted file.");
	            } catch (IOException e1) {
	                JOptionPane.showMessageDialog(fileChooser, "An error occurred during file copying: " + e1.getMessage());
	            } catch (Exception e1) {
	                JOptionPane.showMessageDialog(fileChooser, "An error occurred during the import process: " + e1.getMessage());
	            }
	        }
		return seletedFile;
	}
	
	private void deleteFolder(File folder) {
	    File[] files = folder.listFiles();
	    if (files != null) {
	        for (File file : files) {
	            if (file.isDirectory()) {
	                deleteFolder(file);
	            } else {
	                file.delete();
	            }
	        }
	    }
	    folder.delete();
	}
	
	public void importBackup() {
	   try {
	        existingDbDeleted();
	        File selectedFile = getPrivateImport();
	        System.out.println(selectedFile);
	        FileInputStream input = new FileInputStream(selectedFile);
	        FileOutputStream output = new FileOutputStream("EyeCare.db");
	
	        byte[] buffer = new byte[1024];
	        int bytesRead;
	        while ((bytesRead = input.read(buffer)) != -1) {
	            output.write(buffer, 0, bytesRead);
	        }
	
	        input.close();
	        output.close();
	        
	        File listImportsFolder = new File("listImports");
	
	        if (listImportsFolder.exists()) {
	            deleteFolder(listImportsFolder);
	        }
	        JOptionPane.showMessageDialog(null, "File imported successfully!", "Import Backup File", JOptionPane.INFORMATION_MESSAGE);
	    } catch (IOException e1) {
	    	JOptionPane.showMessageDialog(null, "Error importing file: " + e1.getMessage(), "Import Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	
	private void existingDbDeleted() {
	    File dbFile = new File("EyeCare.db");
	    if (dbFile.exists()) {
	        dbFile.delete();
	    }
	}

}
