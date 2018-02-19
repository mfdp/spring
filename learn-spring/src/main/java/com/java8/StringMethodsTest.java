package com.java8;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringMethodsTest {

	public static void main(String[] args) {
		System.out.println(
			String.join(":", "java", "util", "collections"));

		System.out.println(
		"foobar:foo:bar"
			.chars()
			.mapToObj(c -> String.valueOf((char)c).toUpperCase())
			.sorted()
			.collect(Collectors.joining())
		);

		System.out.println(
		Pattern.compile(":")
			.splitAsStream("foobar:foo:bar")
			.filter(s -> s.contains("bar"))
			.sorted()
			.collect(Collectors.joining("//"))
		);

		Pattern pattern = Pattern.compile(".*@gmail\\.com");
		System.out.println(
			Stream.of("bob@gmail.com", "alice@hotmail.com")
			.filter(pattern.asPredicate())
			.count()
		);



	}

}
