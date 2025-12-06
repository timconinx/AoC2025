package day06;

import java.util.Iterator;

public abstract class Problem {
	public abstract void add(String s);
	public abstract long solve(String s);
	public long doSolve(String op, Iterator<Long> inumbers) {
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
