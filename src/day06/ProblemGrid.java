package day06;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ProblemGrid {
	
	private List<Problem> problems;
	
	public ProblemGrid(int size) {
		problems = new ArrayList<Problem>();
		for (int i = 0; i < size; i++) problems.add(new Problem());
	}
	
	public void add(String line) {
		Iterator<Long> ilongs = Pattern.compile("\\d+")
				.matcher(line)
				.results()
				.map(MatchResult::group)
				.mapToLong(Long::parseLong)
				.iterator();
		int i = 0;
		while (ilongs.hasNext()) {
			problems.get(i).add(ilongs.next());
			i++;
		}
	}
	
	public long solve(String line) {
		Long sum = 0L;
		String[] ops = line.split("\\s+");
		for (int i = 0; i < ops.length; i++) sum += problems.get(i).solve(ops[i]);
		return sum;
	}
}
