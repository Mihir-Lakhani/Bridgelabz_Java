package Java_Streams;

import java.util.*;
import java.util.stream.Collectors;


public class DoubleEachNumber {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(List.of(2,5,3,8));

        List<Integer> doubleNums = nums.stream()
                .map(x -> x*2)
                .collect(Collectors.toUnmodifiableList());

        System.out.println(doubleNums);

    }
}