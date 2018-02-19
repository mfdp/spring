package com.java8.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FooBarTest {

    public static void main(String[] args) {
        List<Foo> foos = new ArrayList<>();

        IntStream
                .range(1, 4)
                .forEach(i -> foos.add(new Foo("Foo" + i)));

        foos.forEach(f ->
                IntStream
                        .range(1, 4)
                        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(b -> System.out.println(b.name));


    }

}
