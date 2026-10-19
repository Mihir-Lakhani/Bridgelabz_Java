package Java_Streams;

import java.util.*;


public class FindTheMinimumAndMaximumEvenNumbers {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(9, 14, 3, 8, 20, 5, 2));

        Optional<Integer> min1 = list.stream()
                .filter(x -> x%2 == 0)
                .min(Integer::compare);

        System.out.println(min1.get());

        OptionalInt max = list.stream()
                .filter(x -> x%2 == 0)
                .mapToInt(n -> n)
                .max();

        max.ifPresent(System.out::println);

    }
}