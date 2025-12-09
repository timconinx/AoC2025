package day08;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import util.InputReader;

public class Day08 {
	private static final String FILE = "day08_test";
	private static final int ITERATIONS = 10;
	
	public static void main(String[] args) {
		List<Coordinate3D> coordinates = InputReader.readInputStream(FILE).map(s -> new Coordinate3D(s)).toList();
		SortedMap<Integer, Coordinate3D[]> distances = new TreeMap<Integer, Coordinate3D[]>();
		for (int i = 0; i < coordinates.size()-1; i++) {
			Coordinate3D one = coordinates.get(i);
			for (int j = i+1; j < coordinates.size(); j++) {
				Coordinate3D other = coordinates.get(j);
				distances.put(one.mDistanceTo(other), new Coordinate3D[] { one, other});
			}
		}
		List<Island> islands = new ArrayList<Island>();
		for (Iterator<Coordinate3D> i = coordinates.iterator(); i.hasNext();) {
			Coordinate3D co = i.next();
			Island is = new Island(co);
			co.setIsland(is);
			islands.add(is);
		}
		
		int iterations = 0;
		for (Iterator<Integer> i = distances.keySet().iterator(); i.hasNext();) {
			Coordinate3D[] pair = distances.get(i.next());
			if (!pair[0].getIsland().getParts().contains(pair[1])) {
				islands.remove(pair[0].getIsland());
				islands.remove(pair[1].getIsland());
				Island newIsland = new Island(pair[0].getIsland(), pair[1].getIsland());
				pair[0].setIsland(newIsland);
				pair[1].setIsland(newIsland);
				islands.add(newIsland);
			}
			iterations++;
			if (iterations > ITERATIONS) break;
		}
		for (Iterator<Island> i = islands.reversed().iterator(); i.hasNext();)
			System.out.println(i.next());
		
		System.out.println("-------");
		SortedSet<Island> sislands = new TreeSet<Island>();
		sislands.addAll(islands);
		
		for (Iterator<Island> i = sislands.reversed().iterator(); i.hasNext();)
			System.out.println(i.next());
		
		iterations = 0;
		long product = 1L;
		for (Iterator<Island> i = sislands.reversed().iterator(); i.hasNext();) {
			product *= i.next().size();
			iterations++;
			if (iterations > 3) break;
		}
		
		System.out.println("Product is " + product);
	}
}
