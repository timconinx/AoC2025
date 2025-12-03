package day03;

import java.util.Iterator;

import util.InputReader;

public class Day03 {

	public static void main(String[] args) {
		Iterator<BatteryLine> lines = InputReader.readInputStream("day03").map(line -> new BatteryLine(line)).toList().iterator();
		long sum = 0;
		while (lines.hasNext()) sum += lines.next().biggestCapacity(12);
		System.out.println("Sum is " + sum);
	}

}
