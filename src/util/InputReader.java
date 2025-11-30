package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class InputReader {

	public static List<String> readInput(String name) {
		List<String> result = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader("input/" + name + ".txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				result.add(line);
			}
		} catch (IOException ioe) {
			throw new RuntimeException(ioe);
		} finally {
			try {
				reader.close();
			} catch (IOException ioe) {
				throw new RuntimeException(ioe);
			}
		}
		return result;
	}
	
	public static Stream<String> readInputStream(String name) {
		return readInput(name).stream();
	}
}
