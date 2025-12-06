package day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CephProblem {
	private List<String> numbers;
	
	private int start;
	
	private int offset;
	
	private String op;
	
	public CephProblem(int start, String op) {
		this.start = start;
		this.offset = op.length();
		this.op = op.split("")[0];
		numbers = new ArrayList<String>();
	}
	
	public void add(String line) {
		int endindex = start + offset -1;
		if (start+offset > line.length()-1)
			numbers.add(line.substring(start));
		else
			numbers.add(line.substring(start, endindex));
	}

	public long solve() {
		Long result = 0L;
		List<Long> numbers2 = getNumbers();
		Iterator<Long> inumbers = numbers2.iterator();
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
	
	private List<Long> getNumbers() {
		List<Long> result = new ArrayList<Long>();
		for (int i = numbers.get(0).length()-1; i >= 0; i--) {
			List<String> numberAsString = new ArrayList<String>();
			for (int j = 0; j < numbers.size(); j++) {
				String number = numbers.get(j).substring(i, i+1);
				if (!number.equals(" ")) numberAsString.add(number);
			}
			result.add(getNumber(numberAsString));
		}
		return result;
	}
	
	private Long getNumber(List<String> numberAsString) {
		Long result = 0L;
		int pow = numberAsString.size()-1;
		for (Iterator<String> i = numberAsString.iterator(); i.hasNext();) {
			result += (long)Math.pow(10, pow) * Long.parseLong(i.next());
			pow--;
		}
		return result;
	}
}
