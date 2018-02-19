package com.java8.functionalinterface.java;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTest {

    public static void main(String[] args) {
        Predicate<String> predicate = (s) -> s.length() > 0;
        Predicate<String> predicate2 = (s) -> s.length() < 0;

        System.out.println(predicate.test(""));
        System.out.println(predicate.and(predicate2).test("A"));

        Predicate<Boolean> nonNull = Objects::nonNull;
        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        Predicate<String> isNotEmpty = isEmpty.negate();
    }

}
