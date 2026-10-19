package Java_Streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamPractice2 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>(List.of(1,3,5,8,6,4));

        //1. Directly printing through the List Stream
        list.stream()
                .filter(x -> x%2 == 0)
                .map(x -> x*2)
                .forEach(System.out::println);  //.forEach(x -> System.out.println(x));

        //2. Storing the new elements in the list in newList
        List<Integer> newList =  list.stream()
                .filter(x -> x%2 == 0)
                .map(x -> x*2)
                .toList();  //.forEach(x -> System.out.println(x));

        System.out.println(newList);

        //2. Converting the list into a Stream then performing the actions
        //a) Directly printing without storing
        Stream<Integer> stream = list.stream();
        stream = stream.filter(x -> x>1);
        stream = stream.map(x -> x%2);
        stream.forEach(x -> System.out.println(x));  //System.out::println

        //b) Storing in a list then printing
        Stream<Integer> stream2 = list.stream();
        stream2 = stream2.filter(x -> x>5);
        stream2 = stream2.map(x -> x%2);
        List<Integer> streamList = stream2.toList();
        //List<Integer> streamList = stream2.collect(Collectors.toUnmodifiableList());
        //List<Integer> streamList = stream2.collect(Collectors.toList());
        //List<Integer> streamList = stream2.collect(Collectors.toCollection(() -> new ArrayList<>()));


        List<List<Integer>> list2D = List.of(
                List.of(2,5,8),
                List.of(3,6,9)
        );
        System.out.println(list2D);

        list2D.stream()
                .flatMap(x -> x.stream())
                .map(x -> 2*x)
                .forEach(System.out::println);

        Stream.iterate(1, x -> x*2)
                .limit(15)
                .skip(5)
                .forEach(System.out::println);



    }
}