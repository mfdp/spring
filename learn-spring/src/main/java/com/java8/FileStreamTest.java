package com.java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileStreamTest {

	public static void main(String[] args) {

		try(Stream<String> line = Files.lines(Paths.get("D:\\log.diff"))) {
			line.filter( lineElement -> lineElement.length() > 150) //
				.map(String::trim)
				.forEach( lineElement -> System.out.println(lineElement));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
