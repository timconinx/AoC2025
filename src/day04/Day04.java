package day04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import util.Coordinate;
import util.InputReader;

public class Day04 {
	private static Map<Coordinate, String> grid = new HashMap<Coordinate, String>();
	private static List<Coordinate> rolls = new ArrayList<Coordinate>();
	private static int maxy = 0;
	private static int maxx = 0;

	public static void main(String[] args) {
		Iterator<String> lines = InputReader.readInput("day04").iterator();
		while (lines.hasNext()) {
			String[] elements = lines.next().split("");
			maxx = elements.length;
			for (int i = 0; i < maxx; i++) {
				Coordinate coordinate = new Coordinate(i, maxy);
				grid.put(coordinate, elements[i]);
				if (elements[i].equals("@")) rolls.add(coordinate);
			}
			maxy++;
		}
		
		int sum = 0;
		List<Coordinate> toberemoved = rollsToBeRemoved();
		System.out.println("initial is " + toberemoved.size());
		
		while(toberemoved.size() > 0) {
			sum += toberemoved.size();
			Iterator<Coordinate> irolls = toberemoved.iterator();
			while (irolls.hasNext()) {
				Coordinate rollco = irolls.next();
				rolls.remove(rollco);
				grid.put(rollco, ".");
			}
			toberemoved = rollsToBeRemoved();
		}
		
		System.out.println("total is " + sum);
	}

	private static List<Coordinate> rollsToBeRemoved() {
		List<Coordinate> toberemoved = new ArrayList<Coordinate>();
		Iterator<Coordinate> irolls = rolls.iterator();
		while (irolls.hasNext()) {
			Coordinate rollco = irolls.next();
			int noneighbours = 0;
			for (int i = 0; i < Coordinate.ALLDIRS.length; i++) {
				Coordinate neighbour = rollco.dir(Coordinate.ALLDIRS[i]);
				if (neighbour.isInBounds(maxx, maxy) && grid.get(neighbour).equals("@")) noneighbours++; 
			}
			if (noneighbours < 4) toberemoved.add(rollco);
		}
		return toberemoved;
	}
}
