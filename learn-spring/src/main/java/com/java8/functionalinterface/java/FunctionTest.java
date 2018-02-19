package com.java8.functionalinterface.java;

import java.util.function.Function;

public class FunctionTest {

    public static void main(String[] args) {
        Function<String, Integer> toInteger = Integer::valueOf;
        Function<String, String> backToString = toInteger.andThen(String::valueOf);

        System.out.println(backToString.apply("123"));

        Function<Integer, Integer> add = (input) -> input + 2;
        Function<Integer, Integer> multiply = (input) -> input * 2;

        System.out.println(add.andThen(multiply).apply(5));
        System.out.println(add.compose(multiply).apply(5));

        Function<Integer, Integer> identity = Function.identity();
        System.out.println(identity.apply(5));
    }
}
