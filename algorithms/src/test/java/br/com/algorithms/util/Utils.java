package br.com.algorithms.util;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Utils {

	public static Stream<String> lines(String resourceFile){
		try {
			return Files.lines(Paths.get(ClassLoader.getSystemResource(resourceFile).toURI()));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
