import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class FileExceptionHandling {
    public static void main(String[] args) {

        // CREATE SCANNER FOR USER INPUT
        Scanner sc = new Scanner(System.in);

        try {
            // TAKE FILE NAME FROM USER
            System.out.print("Enter file name: ");
            String fileName = sc.nextLine();

            // OPEN FILE
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);

            // READ FIRST VALUE FROM FILE
            String data = fileReader.nextLine();

            // CONVERT TO INTEGER
            int number = Integer.parseInt(data);

            // DISPLAY NUMBER
            System.out.println("Number read from file = " + number);

            // CLOSE FILE READER
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            // HANDLE FILE NOT FOUND ERROR
            System.out.println("ERROR: File not found!");
        }
        catch (NumberFormatException e) {
            // HANDLE INVALID FORMAT ERROR
            System.out.println("ERROR: Invalid file format! File must contain a valid integer.");
        }
        catch (Exception e) {
            // HANDLE ANY OTHER ERROR
            System.out.println("ERROR: Something went wrong while reading the file.");
        }
        finally {
            // ALWAYS EXECUTES
            System.out.println("FILE HANDLING COMPLETED.");
            sc.close();
        }
    }
}