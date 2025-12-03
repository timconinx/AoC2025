package day03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatteryLine implements Iterable<Battery> {
	private List<Battery> batteries;
	
	public BatteryLine(String line) {
		batteries = new ArrayList<Battery>();
		String[] numbers = line.split("");
		for (int i = 0; i < numbers.length; i++) batteries.add(new Battery(Integer.parseInt(numbers[i])));
	}
	
	@Override
	public Iterator<Battery> iterator() {
		return batteries.iterator();
	}
	
	public long biggestCapacity(int digits) {
		long sum = 0L;
		int location = -1;
		for (int i = digits-1; i > -1; i--) {
			location = biggestDigitLocation(location+1, batteries.size() - i);
			sum += batteries.get(location).getJoltage()*Math.pow(10, i);
		}
		return sum;
	}
	
	public int biggestDigitLocation(int start, int end) {
		int location = -1;
		for (int i = 9; i > 0; i--) {
			for (int j = start; j < end; j++) {
				if (batteries.get(j).isOfCapacity(i)) {
					location = j;
					break;
				}
			}
			if (location > -1) break;
		}
		return location;
	}
}
