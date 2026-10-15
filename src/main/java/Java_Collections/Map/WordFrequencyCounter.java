package Java_Collections.Map;

import java.util.*;
import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.*;

// Map 1: read a UTF-8 text file; ignore case and treat punctuation as separators.
public class WordFrequencyCounter {

    static Map<String, Integer> countWords(Path file) throws IOException {
        Map<String, Integer> counts = new HashMap<>();
        try (BufferedReader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.toLowerCase(Locale.ROOT).split("[^\\p{L}\\p{N}]+")) {
                    if (!word.isEmpty()) counts.put(word, counts.getOrDefault(word, 0) + 1);
                }
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        Path file = Paths.get(args.length > 0 ? args[0]
                : "src/main/java/Java_Collections/Map/WordFrequencySample.txt");
        try {
            // HashMap does not guarantee order; sort only for predictable display.
            System.out.println(new TreeMap<>(countWords(file)));
        } catch (IOException exception) {
            System.out.println("Unable to read file: " + file);
        }
    }
}
