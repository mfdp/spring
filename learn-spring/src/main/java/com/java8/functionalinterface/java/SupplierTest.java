package com.java8.functionalinterface.java;

import java.util.function.Supplier;

public class SupplierTest {

    public static void main(String[] args) {
        Supplier<Person> personSupplier = () -> new Person("Jan", "Kowalski");
        personSupplier.get(); // new Person

        // Suppliers produce a result of a given generic type. Unlike Functions, Suppliers don't accept arguments.
    }

}
