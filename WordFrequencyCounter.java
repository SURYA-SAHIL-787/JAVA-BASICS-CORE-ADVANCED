import java.io.*;
import java.util.*;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));

            String line;

            while ((line = br.readLine()) != null) {
                String words[] = line.toLowerCase().split("\\W+");

                for (String word : words) {
                    if (!word.isEmpty()) {
                        map.put(word, map.getOrDefault(word, 0) + 1);
                    }
                }
            }

            br.close();

            ArrayList<Map.Entry<String, Integer>> list =
                    new ArrayList<>(map.entrySet());

            list.sort((a, b) -> b.getValue() - a.getValue());

            for (Map.Entry<String, Integer> entry : list) {
                System.out.println(entry.getKey() + " = " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
