package com.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaTest {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, String::compareTo);
    }
}
