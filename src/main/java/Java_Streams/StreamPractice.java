package Java_Streams;

import java.util.*;
import java.util.stream.*;

public class StreamPractice {
    public static void main(String[] args) {

        // 1. List source → collect() terminal operation
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 10)
                .collect(Collectors.toList());

        System.out.println(result); // [20, 40, 60]


        // 2. Array source → sum() terminal operation
        int[] values = {10, 20, 30, 40};

        int total = Arrays.stream(values)
                .filter(n -> n > 15)
                .sum();

        System.out.println(total); // 90


        // 3. Set source → count() terminal operation
        Set<String> names = new HashSet<>(
                Arrays.asList("Aman", "Riya", "Ankit")
        );

        long count = names.stream()
                .filter(name -> name.startsWith("A"))
                .count();

        System.out.println(count); // 2


        // 4. Map entries source → forEach() terminal operation
        Map<String, Integer> marks = new LinkedHashMap<>();
        marks.put("Aman", 80);
        marks.put("Riya", 90);
        marks.put("Rahul", 60);

        marks.entrySet().stream()
                .filter(entry -> entry.getValue() >= 80)
                .forEach(entry ->
                        System.out.println(
                                entry.getKey() + ": " + entry.getValue()
                        )
                );

        // Aman: 80
        // Riya: 90


        // 5. String characters source → anyMatch() terminal operation
        String text = "Java17";

        boolean hasDigit = text.chars()
                .anyMatch(Character::isDigit);

        System.out.println(hasDigit); // true


        // 6. Generated source → reduce() terminal operation
        int sum = Stream.generate(() -> 5)
                .limit(4)
                .reduce(0, Integer::sum);

        System.out.println(sum); // 20


        // 7. Range source → max() terminal operation
        int largest = IntStream.rangeClosed(1, 10)
                .filter(n -> n % 2 == 0)
                .max()
                .orElse(0);

        System.out.println(largest); // 10

    }
}