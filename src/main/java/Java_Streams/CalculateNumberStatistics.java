package Java_Streams;

import java.util.*;


public class CalculateNumberStatistics {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));

        int sum = list.stream()
                .mapToInt(n -> n)
                .sum();
        System.out.println(sum);

        OptionalDouble average = list.stream()
                .mapToInt(n -> n)
                .average();

        average.ifPresentOrElse(System.out::println, () -> System.out.println("No avg found"));

        Long count = list.stream()
                .filter(x -> x%2 == 0)
                .count();

        System.out.println(count);
    }
}