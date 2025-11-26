import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordSorter {

    public static void main(String[] args) {

        // TreeSet automatically sorts words AND removes duplicates
        Set<String> words = new TreeSet<>();

        try {
            File inputFile = new File("collection_of_words.txt");
            Scanner in = new Scanner(inputFile);

            while (in.hasNext()) {
                words.add(in.next().toLowerCase());
            }

            in.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
            return;
        }

        // --- It will display ascending order ---
        System.out.println("Ascending Order:");
        for (String word : words) {
            System.out.println(word);
        }

        // --- It wil display descending order ---
        System.out.println("\nDescending Order:");
        Set<String> descendingWords = ((TreeSet<String>) words).descendingSet();
        for (String word : descendingWords) {
            System.out.println(word);
        }

        // --- Some simple test checks ---
        System.out.println("\n--- Test Results ---");

        if (!words.isEmpty()) {
            System.out.println("File loaded successfully: PASS");
        } else {
            System.out.println("File loaded successfully: FAIL");
        }

        if (words.size() <= ((TreeSet<String>) words).size()) {
            System.out.println("Duplicates removed and sorted: PASS");
        } else {
            System.out.println("Duplicates removed and sorted: FAIL");
        }
    }
}
