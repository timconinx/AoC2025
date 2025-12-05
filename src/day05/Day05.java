package day05;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import util.InputReader;

public class Day05 {
	public static void main(String[] args) {
		Iterator<String> lines = InputReader.readInput("day05").iterator();
		String line = lines.next();
		List<Range> ranges = new ArrayList<Range>();
		while (!line.equals("")) {
			String[] parts = line.split("-");
			Range r = new Range(Long.parseLong(parts[0]), Long.parseLong(parts[1]));
			for (int i = 0; i < ranges.size(); i++) {
				Range other = ranges.get(i);
				if (r.overlaps(other)) {
					ranges.remove(i);
					r = r.merge(other);
					i = 0;
				}
			}
			ranges.add(r);
			line = lines.next();
		}
		int total = 0;
		while (lines.hasNext()) {
			long x = Long.parseLong(lines.next());
			for (int i = 0; i < ranges.size(); i++) {
				if (ranges.get(i).inRange(x)) {
					total++;
					break;
				}
			}
		}
		System.out.println("Total fresh " + total);
		
		long elements = 0L;
		Iterator<Range> iranges = ranges.iterator();
		while (iranges.hasNext())
			elements += iranges.next().nrOfElements();
		
		System.out.println("Total elements " + elements);
	}
}
