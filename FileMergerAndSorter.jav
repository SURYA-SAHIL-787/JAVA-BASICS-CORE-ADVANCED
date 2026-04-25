import java.io.*;
import java.util.*;

public class FileMergerAndSorter {
    public static void main(String[] args) {
        TreeSet<Integer> numbers = new TreeSet<>();

        readNumbers("file1.txt", numbers);
        readNumbers("file2.txt", numbers);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            for (int n : numbers) {
                bw.write(n + "\n");
            }

            bw.close();

            System.out.println("Merged, sorted, and unique numbers written to output.txt");

        } catch (IOException e) {
            System.out.println("Writing error: " + e.getMessage());
        }
    }

    static void readNumbers(String filename, TreeSet<Integer> numbers) {
        try {
            Scanner sc = new Scanner(new File(filename));

            while (sc.hasNextInt()) {
                numbers.add(sc.nextInt());
            }

            sc.close();

        } catch (IOException e) {
            System.out.println("Reading error in " + filename);
        }
    }
}
