package util;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TestInputReader {

	public static void main(String[] args) {
		List<String> input = InputReader.readInput("TestInput");
		Iterator<String> i = input.iterator();
		while (i.hasNext()) System.out.println(i.next());
		System.out.println();
		Stream<String> inputstream = InputReader.readInputStream("TestInput");
		inputstream.forEach(System.out::println);
	}

}
