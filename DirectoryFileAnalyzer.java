import java.io.*;
import java.text.SimpleDateFormat;

public class DirectoryFileAnalyzer {
    static int fileCount = 0;

    public static void main(String[] args) {
        File folder = new File("C:\\Users\\YourName\\Desktop\\TestFolder");

        if (folder.exists() && folder.isDirectory()) {
            analyze(folder);
            System.out.println("Total files: " + fileCount);
        } else {
            System.out.println("Invalid folder path");
        }
    }

    static void analyze(File file) {
        File files[] = file.listFiles();

        if (files == null) {
            return;
        }

        for (File f : files) {
            if (f.isDirectory()) {
                System.out.println("Directory: " + f.getName());
                analyze(f);
            } else {
                fileCount++;

                SimpleDateFormat sdf =
                        new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

                System.out.println("File Name: " + f.getName());
                System.out.println("Size: " + f.length() + " bytes");
                System.out.println("Last Modified: " + sdf.format(f.lastModified()));
                System.out.println("----------------------");
            }
        }
    }
}
