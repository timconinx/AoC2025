package day05;

public class Range {
	private long min;
	
	private long max;
	
	public long Min() {
		return min;
	}
	
	public long Max() {
		return max;
	}
	
	public Range(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof Range && ((Range)obj).Min() == min && ((Range)obj).Max() == max;
	}
	
	@Override
	public int hashCode() {
		return 31*(int)min + 7*(int)max;
	}
	
	@Override
	public String toString() {
		return "[" + min + "," + max + "]";
	}
	
	public boolean inRange(long x) {
		return x >= min && x <= max;
	}
	
	public long nrOfElements() {
		return max - min + 1;
	}
	
	public boolean overlaps(Range r) {
		return inRange(r.Min()) || inRange(r.Max()) || r.inRange(min) || r.inRange(max);
	}
	
	public Range merge(Range r) {
		return new Range(Math.min(min, r.Min()), Math.max(max, r.Max()));
	}
}
