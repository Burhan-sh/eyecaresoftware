package EyeCare;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

import javax.swing.JOptionPane;

public class SingleInstanceChecker {
    private static final String LOCK_FILE_NAME = "myapp.lock";
    private static final String LOCK_FILE_MESSAGE = "Application is already open.";

    private File lockFile;
    private Path lockFilePath;

    public SingleInstanceChecker() {
        lockFile = new File(LOCK_FILE_NAME);
        lockFilePath = FileSystems.getDefault().getPath(LOCK_FILE_NAME);
    }

    public boolean isAppAlreadyRunning() {
        try {
            if (lockFile.createNewFile()) {
                // The lock file is created, this instance is the first one.
                return false;
            } else {
                // The lock file already exists, indicating another instance is running.
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void showAppAlreadyRunningError() {
        try {
            Files.write(lockFilePath, LOCK_FILE_MESSAGE.getBytes(), StandardOpenOption.TRUNCATE_EXISTING);
            JOptionPane.showMessageDialog(null, "The application is already running. Please close the existing instance before starting a new one.", "Warning", JOptionPane.WARNING_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeLockFile() {
        try {
            Files.deleteIfExists(lockFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}