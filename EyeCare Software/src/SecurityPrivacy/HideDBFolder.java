package SecurityPrivacy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class HideDBFolder {
    public static void hideFolder(String folderPath) throws IOException {
        String os = System.getProperty("os.name").toLowerCase();
        if (os.contains("win")) {
            hideFolderWindows(folderPath);
        } else {
            hideFolderUnix(folderPath);
        }
    }

    private static void hideFolderWindows(String folderPath) throws IOException{
        try {
          Runtime runtime = Runtime.getRuntime();
          String command = "attrib +s +h \"" + folderPath + "\"";
          Process process = runtime.exec(command);
          process.waitFor(); // Wait for the command to finish execution
          System.out.println("Folder hidden successfully!");
        } catch (IOException | InterruptedException e) {
          e.printStackTrace();
          System.out.println("Failed to hide folder!");
        }
    }

    private static void hideFolderUnix(String folderPath) throws IOException {
        Path source = Paths.get(folderPath);
        Path target = Paths.get(source.getParent().toString(), "." + source.getFileName().toString());
        Files.move(source, target);
    }
}
