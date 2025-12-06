package day06;

import java.util.List;

import util.InputReader;

public class Day06 {
	public static void main(String[] args) {
		List<String> lines = InputReader.readInput("day06");
		ProblemGrid pg = new ProblemGrid(lines.getFirst().split("\\s+").length);
		for (int i = 0; i < lines.size() -1; i++) pg.add(lines.get(i));
		System.out.println("Sum is " + pg.solve(lines.getLast()));
		
		CephProblemGrid cpg = new CephProblemGrid(lines.getLast());
		for (int i = 0; i < lines.size() -1; i++) cpg.add(lines.get(i));
		System.out.println("Ceph Sum is " + cpg.solve(lines.getLast()));
	}
}
