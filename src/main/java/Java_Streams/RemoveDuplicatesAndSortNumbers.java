package Java_Streams;

import java.util.*;
import java.util.stream.Collectors;


public class RemoveDuplicatesAndSortNumbers {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList <> (List.of(5, 2, 8, 2, 1, 5, 3));

        List<Integer> newList = list.stream()
                .distinct()
                .sorted()
                .collect(Collectors.toCollection(ArrayList::new));

        System.out.println(newList);

    }
}