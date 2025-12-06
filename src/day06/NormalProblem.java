package day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NormalProblem extends Problem {
	private List<Long> numbers = new ArrayList<Long>();
	
	public void add(String number) {
		numbers.add(Long.parseLong(number));
	}
	
	public long solve(String op) {
		Iterator<Long> inumbers = numbers.iterator();
		return doSolve(op, inumbers);
	}
}
