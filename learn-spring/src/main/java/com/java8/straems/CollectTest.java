package com.java8.straems;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectTest {

    public static void main(String[] args) {
        List<String> collect = Stream.of("Ann", "Jack", "Johhny")
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.toList());
        System.out.println(collect);

        Map<Integer, List<String>> result = Stream.of("Ann", "Jack", "Johhny", "Rob")
                .collect(Collectors.groupingBy(name -> name.length()));

        System.out.println(result);

        Double resultDouble = Stream.of("Ann", "Jack", "Johhny", "Rob", "C")
                .collect(Collectors.averagingInt(name -> name.length()));

        System.out.println(resultDouble);

        IntSummaryStatistics collect1 = Stream.of("Ann", "Jack", "Johhny", "Rob", "C")
                .collect(Collectors.summarizingInt(name -> name.length()));

        System.out.println(collect1);

        String collect2 = Stream.of("Ann", "Jack", "Johhny", "Rob", "C")
                .collect(Collectors.joining(" and ", "Hello ", " and say goodbye"));

        System.out.println(collect2);

        Map<Integer, String> collect3 = Stream.of("Ann", "Jack", "Johhny", "Rob", "C")
                .collect(Collectors.toMap(String::length, Function.identity(), (l1, L2) -> l1 + ";" + L2));

        System.out.println(collect3);

        Stream.of("Ann", "Jack", "Johhny", "Rob", "C")
                .reduce((name1, name2) -> {
                    System.out.println("reduce " + name1 + " " + name2);
                    return name1.length() > name2.length() ? name1 : name2;
                } )
                .map( name -> {
                    System.out.println("map: " + name);
                    return name.toUpperCase();
                })
                .ifPresent(System.out::println);

    }

}
