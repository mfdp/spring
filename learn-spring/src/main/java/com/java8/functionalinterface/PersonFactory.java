package com.java8.functionalinterface;

public interface PersonFactory<P> {
    P create(String firstName, String lastName);
}
