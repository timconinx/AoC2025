package day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Problem {
	private List<Long> numbers = new ArrayList<Long>();
	
	public void add(Long number) {
		numbers.add(number);
	}
	
	public long solve(String op) {
		Iterator<Long> inumbers = numbers.iterator();
		Long result = 0L;
		switch (op) {
		case "+":
			while (inumbers.hasNext()) result += inumbers.next();
			return result;
		case "*":
			result = 1L;
			while (inumbers.hasNext()) result *= inumbers.next();
			return result;
		default:
			throw new RuntimeException("invalid operator " + op);
		}
	}
}
