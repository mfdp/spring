package com.java8.functionalinterface.java;

import java.util.function.Consumer;

public class ConsumerTest {

    public static void main(String[] args) {
        Consumer<Person> greeter = (person) -> System.out.println("Hello," + person.firstName + " " + person.lastName);
        Consumer<Person> goodbye = (person) -> System.out.println(" and say GoodBye!!!");
        greeter.andThen(goodbye).accept(new Person("Jan", "Kowalski"));
    }

}
