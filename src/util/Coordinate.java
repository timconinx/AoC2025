package util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class Coordinate {
	public static String[] ALLDIRS = new String[]{"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
	
	private int x;
	
	private int y;
	
	public int X() {
		return x;
	}
	
	public int Y() {
		return y;
	}
	
	public Coordinate(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinate W() {
		return new Coordinate(x - 1, y);
	}

	public Coordinate SW() {
		return new Coordinate(x - 1, y + 1);
	}

	public Coordinate S() {
		return new Coordinate(x, y + 1);
	}

	public Coordinate SE() {
		return new Coordinate(x + 1, y + 1);
	}

	public Coordinate E() {
		return new Coordinate(x + 1, y);
	}

	public Coordinate NE() {
		return new Coordinate(x + 1, y - 1);
	}

	public Coordinate N() {
		return new Coordinate(x, y - 1);
	}

	public Coordinate NW() {
		return new Coordinate(x - 1, y - 1);
	}
	
	public boolean isInBounds(int maxx, int maxy) {
		return (x > -1) && (x < maxx) && (y > -1) && (y < maxy);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj != null) && (obj instanceof Coordinate) && ((Coordinate)obj).X() == x && ((Coordinate)obj).Y() == y;
	}
	
	@Override
	public int hashCode() {
		return x + y;
	}
	
	public Coordinate dir(String direction) {
		switch (direction) {
		case "N":
			return N();
		case "NE":
			return NE();
		case "E":
			return E();
		case "SE":
			return SE();
		case "S":
			return S();
		case "SW":
			return SW();
		case "W":
			return W();
		case "NW":
			return NW();
		default:
			throw new RuntimeException("invalid direction " + direction);
		}
	}
	
	public static Map<String, Method> allDirections() {
		Map<String, Method> alldirs = new HashMap<String, Method>();
		String[] dirs = new String[]{"N", "NE", "E", "SE", "S", "SW", "W", "NW"};
		try {
			for (int i = 0; i < dirs.length; i++)
				alldirs.put(dirs[i], Coordinate.class.getDeclaredMethod(dirs[i], new Class[] {}));
		} catch (Exception allexceptions) {
			throw new RuntimeException(allexceptions);
		}
		return alldirs;
	}
}
