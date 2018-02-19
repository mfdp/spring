package com.java8.straems;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OfArrayStreamTest {

    public static void main(String[] args) {
        Stream.of("Jan", "Kowalski")
                .findFirst().ifPresent(System.out::println);

        System.out.println(IntStream.range(0, 10)
                .sum());

        System.out.println(IntStream.range(0, 10)
                .filter(intValue -> intValue > 5)
                .mapToLong( intValue -> ((Number) intValue).longValue())
                .sum());

        Stream.of("d2", "a2", "b1", "b3", "c")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));

        System.out.println("---------------------");

        Stream.of("d2", "a2", "b1", "b3", "c")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

}
