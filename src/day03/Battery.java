package day03;

public class Battery {
	private int joltage;
	
	public int getJoltage() {
		return joltage;
	}
	
	public Battery(int joltage) {
		this.joltage = joltage;
	}
	
	public boolean isOfCapacity(int cap) {
		return joltage == cap;
	}
}
