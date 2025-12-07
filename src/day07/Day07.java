package day07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Coordinate;
import util.InputReader;

public class Day07 {
	private static final String[] DIRS = new String[] {"W", "E"};
	private static final String NORTH = "N";
	private static final String SOUTH = "S";
	
	private static Map<Coordinate, Boolean> beamed = new HashMap<Coordinate, Boolean>();
	private static List<Coordinate> splitters = new ArrayList<Coordinate>();
	private static Coordinate start;
	
	public static void main(String[] args) {
		List<String> lines = InputReader.readInput("day07_test");
		int maxx = lines.getFirst().length();
		int maxy = lines.size();
		for (int i = 0; i < lines.size(); i++) {
			String[] points = lines.get(i).split("");
			for (int j = 0; j < points.length; j++)
				switch (points[j]) {
				case ".":
					beamed.put(new Coordinate(j, i), false);
					break;
				case "^":
					splitters.add(new Coordinate(j, i));
					break;
				case "S":
					start = new Coordinate(j, i);
					break;
				default:
					throw new RuntimeException("Invalid character " + points[j]);
				}
		}
		
		int splitted = 0;
		for (int i = 1; i < lines.size(); i++) {
			for (int j = 0; j < lines.getFirst().length(); j++) {
				Coordinate current = new Coordinate(j, i);
				Coordinate north = current.dir(NORTH);
				if (splitters.contains(current)) {
					if (beamed.get(north) != null && beamed.get(north)) {
						splitted++;
						for (int k = 0; k < DIRS.length; k++) {
							Coordinate nextTo = current.dir(DIRS[k]);
							if (nextTo.isInBounds(maxx, maxy) && !splitters.contains(nextTo)) beamed.put(nextTo, true);
						}
					}
				} else {
					if (north.equals(start) || (beamed.get(north) != null && beamed.get(north))) {
						beamed.put(current, true);
					}
				}
			}
		}
		System.out.println("Number splitted = " + splitted);
		
		int timeSplitted = 1;
		List<Coordinate> colored = new ArrayList<Coordinate>();
		List<Coordinate> splitPoints = new ArrayList<Coordinate>();
		splitPoints.add(start);
		while (!splitPoints.isEmpty()) {
			Coordinate point = splitPoints.removeLast();
			Coordinate south = point.dir(SOUTH);
			while (south.isInBounds(maxx, maxy)) {
				colored.add(south);
				if (splitters.contains(south)) {
					timeSplitted++;
					for (int i = 0; i < DIRS.length; i++) {
						Coordinate nextTo = south.dir(DIRS[i]);
						if (nextTo.isInBounds(maxx, maxy) && !splitters.contains(nextTo) && !colored.contains(nextTo)) {
							splitPoints.add(nextTo);
						}
					}
					break;
				} else {
					south = south.dir(SOUTH);
				}
			}
		}
		System.out.println("Time splitted = " + timeSplitted);
	}
}
