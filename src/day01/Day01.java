package day01;

import java.util.Iterator;

public class Day01 {

	public static void main(String[] args) {
		String file = "day01";
		Iterator<String> lines = util.InputReader.readInput(file).iterator();
		int position = 50;
		int reached = 0;
		int over = 0;
		while (lines.hasNext()) {
			String line = lines.next();
			String dir = line.substring(0, 1);
			int number = Integer.parseInt(line.substring(1));
			if ("R".equals(dir)) {
				position += number;
				while (position > 99) {
					over++;
					position -= 100;
				}
			} else if ("L".equals(dir)) {
				int prev = position;
				position -= number;
				while (position < 1 && position != 0) {
					over++;
					position += 100;
				}
				if (prev == 0) over--;
				if (position == 0) over++;
			} else throw new RuntimeException("invalid direction " + dir);
			if (position == 0) reached++;
		}
		System.out.println("reached 0 = " + reached);
		System.out.println("over 0 = " + over);
	}

}
