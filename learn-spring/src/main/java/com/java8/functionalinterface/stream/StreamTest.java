package com.java8.functionalinterface.stream;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StreamTest {

    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        boolean b = stringCollection.stream() //
                .filter(stringElement -> stringElement.length() > 2)
                .map(stringElement -> stringElement.length())
                .anyMatch(l -> l > 0);

        System.out.println(b);

        Map<String, Integer> map = new HashMap<>();
        map.forEach( (x, y ) -> {});
    }

}
