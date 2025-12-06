package day06;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CephProblemGrid implements ProblemGrid {
	private List<CephProblem> problems;
	
	public CephProblemGrid(String line) {
		problems = new ArrayList<CephProblem>();
		Matcher m =  Pattern.compile("[\\*\\+]\\s+").matcher(line);
		while (m.find())
			problems.add(new CephProblem(m.start(), m.group()));
	}
	
	public void add(String line) {
		for (int i = 0; i < problems.size(); i++) problems.get(i).add(line);
	}
	
	public long solve(String line) {
		Long sum = 0L;
		for (int i = 0; i < problems.size(); i++) sum += problems.get(i).solve(null);
		return sum;
	}
}
