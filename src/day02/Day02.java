package day02;

public class Day02 {

	public static boolean checkInvalid(long idn) {
		String id = "" + idn;
		int length = id.length();
		if (length % 2 == 0) {
			if (id.substring(0, length /2).equals(id.substring(length/2))) return true;
		}
		return false;
	}
	
	public static boolean checkInvalid2(long idn) {
		String id = "" + idn;
		int length = id.length();
		for (int i = length; i > 2; i--) {
			if (length % i == 0) {
				int div = length / i;
				boolean invalid = true;
				for (int j = 0; j <= length - 2*div; j += div) {
					if (invalid) invalid = invalid && id.substring(j, j+div).equals(id.substring(j+div, j+div+div));
				}
				if (invalid) return true;
				
			}
		}
		return false;
	}

	public static void main(String[] args) {
		String[] parts = util.InputReader.readInput("day02").getFirst().split(",");
		long sumpart1 = 0;
		long sumpart2 = 0;
		for (int i = 0; i < parts.length; i++) {
			String[] range = parts[i].split("-");
			long start = Long.parseLong(range[0]);
			long end = Long.parseLong(range[1]);
			while (start <= end) {
				if (checkInvalid(start)) {
					sumpart1 += start;
					sumpart2 += start;
				} else if (checkInvalid2(start)) {
					sumpart2 += start;
				}
				start++;
			}
		}
		System.out.println("sum (part 1) is " + sumpart1);
		System.out.println("sum (part 2) is " + sumpart2);
	}

}
